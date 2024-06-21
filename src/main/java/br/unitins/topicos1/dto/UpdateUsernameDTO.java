package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Size;

public record UpdateUsernameDTO(
    @Size(min = 2, max = 50)
    String username
) {
    
}
