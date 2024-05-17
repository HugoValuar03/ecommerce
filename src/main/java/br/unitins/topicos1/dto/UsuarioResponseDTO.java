package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Pessoa;

public record UsuarioResponseDTO(
    String username,
    String nome
) {
    public static UsuarioResponseDTO valueOf(Pessoa pf) {
        return new UsuarioResponseDTO(
                pf.getUsuario().getUsername(),
                pf.getNome()
            );
    }
}
