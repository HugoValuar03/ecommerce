package br.unitins.topicos1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.StatusPedido;
import br.unitins.topicos1.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    public static final Logger LOG = Logger.getLogger(PessoaServiceImpl.class);

    @Inject
    public PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {

        Pedido pedido = new Pedido();
        pedido.setTotal(0.0);
        pedido.setData(LocalDateTime.now());

        List<ItemPedido> itens = new ArrayList<ItemPedido>();

        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();
            item.getProduto().setNomeModelo(itemDTO.produto().nomeModelo());
            item.getProduto().getMarca().setMarca((itemDTO.produto().marca().marca()));
            itens.add(item);
        }

        pedido.setListaItens(itens);

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        LOG.info("Realizando requisição Pedido.findById()");
        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null)
            return PedidoResponseDTO.valueOf(pedido);
        return null;
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
        LOG.info("Realizando requisição Pedido.findByCliente()");
        return pedidoRepository.findByCliente(idCliente).stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
        LOG.info("Realizando requisição Pedido.delete()");
    }

    @Override
    @Transactional
    public Response realizarPagamento(Long id) {

        Pedido pedido = pedidoRepository.findById(id);
        if (pedido != null) {
            pedido.setStatusPedido(StatusPedido.PAGAMENTO_PENDENTE);
            pedido.setPago(true);
            LOG.info("Requisição Pedido.realiarPagamento()");
            return Response.status(Status.OK).build();
        }else{
            LOG.error("Erro ao rodar requisição Pedido.realizarPagamento()");
            return null;
        }

    }

    @Override
    public Response mudarStatusPedido(Long id, int idStatusPedido) {
        Pedido pedido = pedidoRepository.findById(id);
        if(pedido != null){
            pedido.setStatusPedido(StatusPedido.valueOf(idStatusPedido));
            return Response.status(Status.OK).build();
        } else{
            LOG.error("Erro ao alterar status");
            return null;
        }
            
    }

}