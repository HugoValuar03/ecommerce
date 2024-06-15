package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.BandeiraCartao;
import jakarta.persistence.Enumerated;

public record CartaoDTO(
    String nome,
    @Enumerated BandeiraCartao bandeiraCartao,
    String numero,
    Integer pessoa
) {}
