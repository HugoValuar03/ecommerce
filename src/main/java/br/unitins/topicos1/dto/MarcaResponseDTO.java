package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Marca;

public record MarcaResponseDTO(
    Long idMarca,
    String marca
) {
    public static MarcaResponseDTO valueOf(Marca marca){
        return new MarcaResponseDTO(
            marca.getId(), 
            marca.getMarca()
        );
    }
}
