package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.BandeiraCartao;
import br.unitins.topicos1.model.Cartao;
import jakarta.persistence.Enumerated;

public record CartaoResponseDTO(
    Long id,
    String nome,
    @Enumerated BandeiraCartao bandeiraCartao,
    Long idPessoa
) {
    public static CartaoResponseDTO valueOf(Cartao cartao){
        return new CartaoResponseDTO(
            cartao.getId(), 
            cartao.getNome(), 
            cartao.getBandeiraCartao(), 
            cartao.getPessoa().getId());
    }
}
