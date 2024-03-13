package br.unitins.topicos1.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PessoaDTO(
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 65, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    String nome, 
    
    @Email(message = "Insira um Email válido")
    @NotBlank(message = "Email é obrigatório")
    @Size(min = 11, max = 90, message = "O Tamanho deve ser entre 11 e 90 caracteres")
    String email, 
    
    @NotBlank(message = "Cargo é obrigatório")
    @Size(min = 5, max = 40, message = "O Tamanho deve ser entre 5 e 40 caracteres")
    String cargo, 
    
    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 14, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    String cpf, 
    
    @NotBlank(message = "CEP é obrigatório")
    @Size(min = 8, max = 8, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    String cep, 

    @NotBlank(message = "Endereço é obrigatório")
    @Size(min = 3, max = 65, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    String endereco, 
    
    @Size(max = 150, message = "O complemento deve ter até 150 caracteres")
    String complemento, 

    @NotBlank(message = "Cidade obrigatória")
    @Size(max = 30)
    String cidade, 

    @NotBlank(message = "O estado é obigatorio")
    @Size(min = 2, max = 2)
    String estado, 
    
    @NotBlank(message = "Telefone obrigatório")
    @Size(min = 11, max = 11)
    String telefone, 

    @NotBlank(message = "Data de nascimento obrigatória")
    @Size(min = 8, max = 11)
    LocalDate aniversario) {}
    