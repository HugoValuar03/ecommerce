package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Acessorios.Compatibilidade;
import br.unitins.topicos1.model.Acessorios.Cor;
import br.unitins.topicos1.model.Acessorios.TipoAcessorio;

public record AcessoriosDTO(
    String nomeProduto,
    Double preco,
    TipoAcessorio acessorio,
    Compatibilidade compatibilidade,
    Double altura,
    Double largura,
    String material,
    Double peso,
    Cor cor
) {
}