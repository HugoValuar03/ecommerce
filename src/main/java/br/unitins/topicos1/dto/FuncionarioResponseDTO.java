package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.Funcionario;

public record FuncionarioResponseDTO(

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

    public static FuncionarioResponseDTO valueOf(Funcionario funcionario){
        return new FuncionarioResponseDTO(
            funcionario.getNome(), 
            funcionario.getEmail(), 
            funcionario.getCargo(), 
            funcionario.getCpf(), 
            funcionario.getCep(), 
            funcionario.getEndereco(), 
            funcionario.getComplemento(), 
            funcionario.getCidade(), 
            funcionario.getEstado(), 
            funcionario.getTelefone(), 
            funcionario.getAniversario()
        );      
    }
 
}
