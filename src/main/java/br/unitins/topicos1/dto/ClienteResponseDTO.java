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
    List<TelefoneResponseDTO> lista = cliente.getListaTelefone()
                                            .stream()
                                            .map(TelefoneResponseDTO::valueOf)
                                            .toList();
        return new ClienteResponseDTO(
            cliente.getIdCliente(),
            cliente.getNome(),
            cliente.getEmail(),
            cliente.getCpf(),
            cliente.getSexo(),
            cliente.getAniversario(),
            lista
        );      
    }
}