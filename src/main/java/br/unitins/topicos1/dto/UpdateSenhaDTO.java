package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Size;

public record UpdateSenhaDTO(
    @Size(min = 3, max = 1000)
    String novaSenha,
    @Size(min = 3, max = 1000)
    String senhaAntiga
) {
    
}
