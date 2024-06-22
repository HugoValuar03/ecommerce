package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cartao;

public record CartaoResponseDTO(
    Long id,
    String nome,
    Long idPessoa
) {
    public static CartaoResponseDTO valueOf(Cartao cartao){
        return new CartaoResponseDTO(
            cartao.getId(), 
            cartao.getNome(), 
            cartao.getPessoa().getId());
    }
}
