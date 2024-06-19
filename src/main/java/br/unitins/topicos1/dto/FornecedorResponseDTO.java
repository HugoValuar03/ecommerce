package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;

public record FornecedorResponseDTO(
    Long id,
    String nome,
    String endereco,
    String email,
    TelefoneResponseDTO telefone,
    String cnpj
) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor){

        return new FornecedorResponseDTO(
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getEndereco(),
            fornecedor.getEmail(),
            TelefoneResponseDTO.valueOf(fornecedor.getTelefone()),
            fornecedor.getCnpj()
        );
    }
}
