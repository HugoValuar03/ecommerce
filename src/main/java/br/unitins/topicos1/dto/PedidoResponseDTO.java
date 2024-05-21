package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.Pedido;

public record PedidoResponseDTO(
    Long id,
    ClienteResponseDTO cliente,
    Double total,
    List<ItemPedidoResponseDTO> itens
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        List<ItemPedidoResponseDTO> lista = pedido.getItens()
                                            .stream()
                                            .map(ItemPedidoResponseDTO::valueOf)
                                            .toList();
        return new PedidoResponseDTO(
            pedido.getId(), 
            ClienteResponseDTO.valueOf(pedido.getCliente()),
            pedido.getTotal(),
            lista);
    }

}