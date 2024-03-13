package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.Pessoa;

public record PessoaResponseDTO(

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
    LocalDate aniversario

) {

    public static PessoaResponseDTO valueOf(Pessoa pessoa){
        return new PessoaResponseDTO(
            pessoa.getNome(), 
            pessoa.getEmail(), 
            pessoa.getCargo(), 
            pessoa.getCpf(), 
            pessoa.getCep(), 
            pessoa.getEndereco(), 
            pessoa.getComplemento(), 
            pessoa.getCidade(), 
            pessoa.getEstado(), 
            pessoa.getTelefone(), 
            pessoa.getAniversario()
        );      
    }
 
}
