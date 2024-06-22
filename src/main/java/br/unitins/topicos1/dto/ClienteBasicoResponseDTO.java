package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Sexo;

public record ClienteBasicoResponseDTO(
    Long idCliente,
    String nome,
    String cpf,
    Sexo sexo,
    String username
) {
    public static ClienteBasicoResponseDTO valueOf(Cliente cliente) {
        return new ClienteBasicoResponseDTO(
            cliente.getId(), 
            cliente.getPessoa().getNome(),
            cliente.getPessoa().getCpf(),
            cliente.getPessoa().getSexo(),
            cliente.getPessoa().getUsername()
        );
    }
}
