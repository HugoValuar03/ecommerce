package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Sexo;

public record ClienteResponseDTO(
    
    Long id,
    String nome,
    String email,
    String cpf,
    Sexo sexo,
    LocalDate aniversario,
    TelefoneResponseDTO telefone
){
    public static ClienteResponseDTO valueOf(Cliente cliente){
        return new ClienteResponseDTO(
            cliente.getPessoa().getId(),
            cliente.getPessoa().getNome(),
            cliente.getPessoa().getEmail(),
            cliente.getPessoa().getCpf(),
            cliente.getPessoa().getSexo(),
            cliente.getPessoa().getAniversario(),
            TelefoneResponseDTO.valueOf(cliente.getPessoa().getTelefone())
        );      
    }
}