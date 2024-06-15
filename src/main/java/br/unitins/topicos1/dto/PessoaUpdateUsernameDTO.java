package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Size;

public record PessoaUpdateUsernameDTO(
    @Size(min = 2, max = 50)
    String username,
    @Size(min = 3, max = 1000)
    String senha
) {
    
}
