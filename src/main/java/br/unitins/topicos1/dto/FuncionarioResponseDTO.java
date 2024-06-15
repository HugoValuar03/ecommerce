package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Funcionario;

public record FuncionarioResponseDTO(

    Long idFuncionario,
    String cargo,
    PessoaResponseDTO pessoa

) {

    public FuncionarioResponseDTO(Funcionario funcionario){
        this(
            funcionario.getId(),
            funcionario.getCargo(),
            new PessoaResponseDTO(funcionario.getPessoa())
        );     
    }
 
}
