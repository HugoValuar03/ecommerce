package br.unitins.topicos1.dto;

public record ProdutoDTO(
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    MarcaDTO marca,
    Long idfornecedor
) {}