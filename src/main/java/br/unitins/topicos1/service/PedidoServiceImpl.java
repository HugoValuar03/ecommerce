package br.unitins.topicos1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    public PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO create(@Valid PedidoDTO dto) {

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());

        List<ItemPedido> itens = new ArrayList<ItemPedido>();

        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido item = new ItemPedido();
            item.setDesconto(itemDTO.desconto());
            item.setPreco(itemDTO.preco());
            itens.add(item);
        }

        pedido.setItens(itens);

        pedidoRepository.persist(pedido);
        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
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
        return pedidoRepository.findByCliente(idCliente).stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

}