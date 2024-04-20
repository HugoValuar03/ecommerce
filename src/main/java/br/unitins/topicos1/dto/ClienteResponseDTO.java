package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Sexo;

public record ClienteResponseDTO(

    Long id,
    String nome,
    String email,
    String cpf,
    Sexo sexo,
    LocalDate aniversario,
    List<TelefoneResponseDTO> listaTelefone
){
    public static ClienteResponseDTO valueOf(Cliente cliente){
    List<TelefoneResponseDTO> lista = cliente.getPessoa().getListaTelefone()
                                            .stream()
                                            .map(TelefoneResponseDTO::valueOf)
                                            .toList();
        return new ClienteResponseDTO(
            cliente.getPessoa().getId(),
            cliente.getPessoa().getNome(),
            cliente.getPessoa().getEmail(),
            cliente.getPessoa().getCpf(),
            cliente.getPessoa().getSexo(),
            cliente.getPessoa().getAniversario(),
            lista
        );      
    }
}