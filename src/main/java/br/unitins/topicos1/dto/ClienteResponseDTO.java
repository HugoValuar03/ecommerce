package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cliente;

public record ClienteResponseDTO(
    
    Long id,
    PessoaResponseDTO pessoa
){
    public ClienteResponseDTO(Cliente cliente){
        this(
            cliente.getId(),
            new PessoaResponseDTO(cliente.getPessoa())
        );      
    }
}