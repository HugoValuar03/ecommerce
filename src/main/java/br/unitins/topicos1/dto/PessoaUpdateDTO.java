package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record PessoaUpdateDTO(
    @Size(min = 2, max = 50)
    String nome, 
    @Email
    String email,
    @Size(min = 3, max = 25)
    String username,
    @Size(min = 3, max = 1000)
    String senha
) {}
