package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.model.Sexo;

public record FuncionarioResponseDTO(

    Long idFuncionario,
    String cargo,
    String nome,
    String email,
    String cpf,
    Sexo sexo,
    LocalDate aniversario,
    List<TelefoneResponseDTO> listaTelefone

) {

    public static FuncionarioResponseDTO valueOf(Funcionario funcionario){
        List<TelefoneResponseDTO> lista = funcionario.getListaTelefone()
                                            .stream()
                                            .map(TelefoneResponseDTO::valueOf)
                                            .toList();
        return new FuncionarioResponseDTO(
            funcionario.getIdFuncionario(),
            funcionario.getCargo(),
            funcionario.getNome(),
            funcionario.getEmail(),
            funcionario.getCpf(),
            funcionario.getSexo(),
            funcionario.getAniversario(),
            lista
        );      
    }
 
}
