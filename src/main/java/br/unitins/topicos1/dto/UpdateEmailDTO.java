package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Email;

public record UpdateEmailDTO(
    @Email
    String email
) {
    
}
