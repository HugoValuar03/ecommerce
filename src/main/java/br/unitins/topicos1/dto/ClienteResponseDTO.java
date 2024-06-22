package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cliente;

public record ClienteResponseDTO(
    
    Long id,
    PessoaResponseDTO pessoa
){
    public static ClienteResponseDTO valueOf(Cliente cliente){
        return new ClienteResponseDTO(
            cliente.getId(),
            PessoaResponseDTO.valueOf(cliente.getPessoa())
        );      
    }
}