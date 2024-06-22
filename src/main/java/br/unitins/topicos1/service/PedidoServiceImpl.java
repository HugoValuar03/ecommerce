package br.unitins.topicos1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.Produto;
import br.unitins.topicos1.model.StatusPedido;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.ProdutoRepository;
import br.unitins.topicos1.validation.ValidationException;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService{

    @Inject
    public PedidoRepository pedidoRepository;

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    SecurityIdentity security;

    @Inject
    JsonWebToken jwt;

    @Inject
    public ProdutoRepository produtoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {
        String username = security.getPrincipal().getName();

        Cliente clienteAutenticado = clienteRepository.findById(dto.idCliente());
        if (clienteAutenticado == null) {
            throw new ValidationException("Erro", "Erro ao buscar cliente");
        }

        if(!clienteEstaAutenticado(username, dto.idCliente())){
            throw new ValidationException("Verificando...", "Você não tem autorização para realizar o pedido.");
        }

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setCliente(clienteAutenticado);
        pedido.setFormaPagamento(FormaPagamento.valueOf(dto.idPagamento()));
        
        List<ItemPedido> itens = new ArrayList<>();
        Double valorTotal = 0.0;
        
        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();
            item.setProduto(produtoRepository.findById(itemDTO.idProduto()));
            item.setQuantidade(itemDTO.quantidade());   
            
            itens.add(item);

            valorTotal += calcularTotal(item.getProduto(), item);
        }
        
        pedido.setListaItens(itens);
        pedido.setTotal(valorTotal);

        pedido.setStatusPedido(StatusPedido.PAGAMENTO_PENDENTE);

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
    }

    private Double calcularTotal(Produto produto, ItemPedido item){
        Double precoProduto = produto.getPreco();
        return precoProduto * item.getQuantidade();    
    }

    public boolean clienteEstaAutenticado(String username, Long idCliente){
        Cliente clienteAutenticado = clienteRepository.findByUsername(username);
        return clienteAutenticado != null && clienteAutenticado.getId().equals(idCliente);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(pedidoRepository.findById(id));
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        return pedidoRepository
        .listAll()
        .stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByCliente(Long idCliente) {
        return pedidoRepository.findByCliente(idCliente).stream().map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public List<PedidoResponseDTO> meusPedidos() {
        String username = jwt.getName();
        List<PedidoResponseDTO> pedidos = pedidoRepository.find("cliente.pessoa.username", username).stream().map(e -> PedidoResponseDTO.valueOf(e)).toList();
        
        if(pedidos.isEmpty()){
            throw new NotFoundException("Você ainda não fez nenhum pedido.");
        }
        return pedidos;
    }

    @Override
    @Transactional
    public void mudarStatusPedido(Long idPedido){
        Pedido pedido = pedidoRepository.findById(idPedido);

        if(pedido == null){
            throw new ValidationException("Erro","O pedido não foi encontrado.");
        }

        String username = jwt.getName();
        if(!pedidoEdoCliente(username, pedido)){
            throw new ValidationException("Erro","Você não tem permissão para alterar o status do pagamento");
        }

        if (pedido.getStatusPedido() == StatusPedido.PAGAMENTO_PENDENTE) {
            pedido.setStatusPedido(StatusPedido.PAGO);
        } else if(pedido.getStatusPedido() == StatusPedido.PAGO){
            throw new ValidationException("Erro","Você já pagou este pedido.");
        } else {
            throw new ValidationException("Erro","O Pedido não foi encontrado");
        }    
    }

    private boolean pedidoEdoCliente(String username, Pedido pedido){
        return pedido.getCliente().getPessoa().getUsername().equals(username);
    }
}