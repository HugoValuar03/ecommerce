package br.unitins.topicos1.dto;

public record ItemPedidoDTO(
    ProdutoDTO produto,
    Integer quantidade,
    Long idPedido
) {
    
}
