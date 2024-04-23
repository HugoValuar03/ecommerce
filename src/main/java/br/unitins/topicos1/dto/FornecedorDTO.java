package br.unitins.topicos1.dto;

import java.util.List;

public record FornecedorDTO(
    String nome,
    String endereco,
    String email,
    List<TelefoneDTO> telefone,
    String cnpj
) {}
