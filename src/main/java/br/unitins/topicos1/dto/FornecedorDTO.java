package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FornecedorDTO(

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 65, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    String nome,

    @NotBlank(message = "Endereço é obrigatório")
    @Size(min = 3, max = 65, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    String endereco,

    @Email(message = "Insira um Email válido")
    @NotBlank(message = "Insira um Email válido")
    @Size(min = 11, max = 90, message = "O Tamanho deve ser entre 11 e 90 caracteres")
    String email,

    @NotBlank(message = "Telefone obrigatório")
    @Size(min = 11, max = 11)
    String telefone,

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 14, max = 18, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    String cnpj
) {
    
}
