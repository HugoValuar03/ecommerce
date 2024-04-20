package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;

public record PessoaResponseDTO(
    Long id,
    String nome,
    String email,
    String cpf,
    Sexo sexo,
    LocalDate aniversario,
    List<TelefoneResponseDTO> listaTelefone
) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa){
        List<TelefoneResponseDTO> lista = pessoa.getListaTelefone()
                                            .stream()
                                            .map(TelefoneResponseDTO::valueOf)
                                            .toList();  
        return new PessoaResponseDTO(
            pessoa.getId(),
            pessoa.getNome(),
            pessoa.getEmail(), 
            pessoa.getCpf(),
            pessoa.getSexo(),
            pessoa.getAniversario(), 
            lista
        );
    }
}
