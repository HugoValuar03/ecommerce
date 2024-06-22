package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;

public record PessoaResponseDTO(
    Long id,
    String nome,
    String email,
    String cpf,
    Sexo sexo,
    LocalDate aniversario,
    TelefoneResponseDTO telefone,
    String username
) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa){
        return new PessoaResponseDTO(
            pessoa.getId(),
            pessoa.getNome(),
            pessoa.getEmail(), 
            pessoa.getCpf(),
            pessoa.getSexo(),
            pessoa.getAniversario(), 
            TelefoneResponseDTO.valueOf(pessoa.getTelefone()),
            pessoa.getUsername()
        );
    }
}
