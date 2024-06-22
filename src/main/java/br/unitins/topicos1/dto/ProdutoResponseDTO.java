package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Produto;

public record ProdutoResponseDTO(
    Long id,
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    MarcaResponseDTO marca,
    Fornecedor fornecedor
) {
    public static ProdutoResponseDTO valueOf(Produto produto){
        return new ProdutoResponseDTO(
            produto.getId(),
            produto.getNomeModelo(),
            produto.getPreco(),
            produto.getMaterial(),
            produto.getDimensoes(),
            MarcaResponseDTO.valueOf(produto.getMarca()),
            produto.getFornecedor()
        );
    }
}
