package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.ItemPedido;

public record ItemPedidoResponseDTO(
    Long id,
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    MarcaResponseDTO marca,
    Fornecedor fornecedor,
    Integer quantidade
) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
        return new ItemPedidoResponseDTO(
            item.getId(), 
            item.getProduto().getNomeModelo(),
            item.getProduto().getPreco(),
            item.getProduto().getMaterial(),
            item.getProduto().getDimensoes(),
            new MarcaResponseDTO(item.getProduto().getMarca().getId(), item.getProduto().getMarca().getMarca()),
            item.getProduto().getFornecedor(),
            item.getQuantidade()
        );
    }
} 
