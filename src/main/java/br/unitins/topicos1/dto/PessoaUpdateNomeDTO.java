package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Size;

public record PessoaUpdateNomeDTO(
    @Size(min = 2, max = 50)
    String nome,
    @Size(min = 3, max = 1000)
    String senha
) {
    
}
