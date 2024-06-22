package br.unitins.topicos1.dto;

public record ClienteBasicoDTO(
    String nome, 
    String cpf,
    Integer idSexo,
    String username,
    String senha
) {
}
