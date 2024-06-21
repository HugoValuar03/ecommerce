package br.unitins.topicos1.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.StatusPedido;

public record PedidoResponseDTO(
    Long id,
    ClienteResponseDTO cliente,
    LocalDateTime dataPedido,
    List<ItemPedidoResponseDTO> itens,
    Double total,
    FormaPagamento pagamento,
    StatusPedido statusPedido
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        List<ItemPedidoResponseDTO> lista = pedido.getListaItens()
                                            .stream()
                                            .map(ItemPedidoResponseDTO::valueOf)
                                            .toList();
        return new PedidoResponseDTO(
            pedido.getId(), 
            new ClienteResponseDTO(pedido.getCliente()),
            pedido.getDataPedido(),
            lista,
            pedido.getTotal(),
            pedido.getFormaPagamento(),
            pedido.getStatusPedido());
    }
}