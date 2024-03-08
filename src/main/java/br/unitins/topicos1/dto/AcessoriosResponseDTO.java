package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Acessorios;
import br.unitins.topicos1.model.Acessorios.Compatibilidade;
import br.unitins.topicos1.model.Acessorios.Cor;
import br.unitins.topicos1.model.Acessorios.TipoAcessorio;

public record AcessoriosResponseDTO(
    String nomeProduto,
    Double preco,
    TipoAcessorio acessorio,
    Compatibilidade compatibilidade,
    Integer altura,
    Integer largura,
    String material,
    Double peso,
    Cor cor
) {
    public static AcessoriosResponseDTO valueOf(Acessorios acessorios){
        return new AcessoriosResponseDTO(
            acessorios.getNomeProduto(),
            acessorios.getPreco(),
            acessorios.getAcessorio(),
            acessorios.getCompatibilidade(),
            acessorios.getAltura(),
            acessorios.getLargura(),
            acessorios.getMaterial(),
            acessorios.getPeso(),
            acessorios.getCor()
        );
    }
}
