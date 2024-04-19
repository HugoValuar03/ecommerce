package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.Produto;

public record FornecedorDTO(
    String nome,
    String endereco,
    String email,
    List<TelefoneDTO> telefones,
    Produto produto,
    String cnpj
) {
    
}
