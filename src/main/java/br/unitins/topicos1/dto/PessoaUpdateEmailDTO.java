package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record PessoaUpdateEmailDTO(
    @Email
    String email,
    @Size(min = 3, max = 1000)
    String senha
) {
    
}
