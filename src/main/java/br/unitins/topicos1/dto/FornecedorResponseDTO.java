package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;

public record FornecedorResponseDTO(
    String nome,
    String endereco,
    String email,
    String telefone,
    String cnpj
) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor){
        return new FornecedorResponseDTO(
            fornecedor.getNome(),
            fornecedor.getEndereco(),
            fornecedor.getEmail(),
            fornecedor.getTelefone(),
            fornecedor.getCnpj()
        );
    }
}
