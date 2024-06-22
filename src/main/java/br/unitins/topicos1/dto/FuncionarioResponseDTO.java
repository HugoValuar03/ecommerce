package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Funcionario;

public record FuncionarioResponseDTO(

    Long idFuncionario,
    String cargo,
    PessoaResponseDTO pessoa

) {

    public static FuncionarioResponseDTO valueOf(Funcionario funcionario){
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getCargo(),
            PessoaResponseDTO.valueOf(funcionario.getPessoa())
        );     
    }
 
}
