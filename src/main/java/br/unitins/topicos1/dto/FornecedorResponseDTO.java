package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.Fornecedor;

public record FornecedorResponseDTO(
    Long id,
    String nome,
    String endereco,
    String email,
    List<TelefoneResponseDTO> listaTelefone,
    String cnpj
) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor){
        List<TelefoneResponseDTO> lista = fornecedor.getListaTelefone()
                                            .stream()
                                            .map(TelefoneResponseDTO::valueOf)
                                            .toList();  

        return new FornecedorResponseDTO(
            fornecedor.getIdFornecedor(),
            fornecedor.getNome(),
            fornecedor.getEndereco(),
            fornecedor.getEmail(),
            lista,
            fornecedor.getCnpj()
        );
    }
}
