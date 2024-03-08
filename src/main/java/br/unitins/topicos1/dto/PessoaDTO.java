package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record PessoaDTO(
    String nome, 
    String email, 
    String cargo, 
    String cpf, 
    String cep, 
    String endereco, 
    String complemento, 
    String cidade, 
    String estado, 
    String telefone, 
    LocalDate aniversario) {}
    