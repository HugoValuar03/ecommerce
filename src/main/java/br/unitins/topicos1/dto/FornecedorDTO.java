package br.unitins.topicos1.dto;

public record FornecedorDTO(
    String nome,
    String endereco,
    String email,
    TelefoneDTO telefone,
    String cnpj
) {}