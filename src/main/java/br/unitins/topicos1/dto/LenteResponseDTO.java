package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Lente;

public record LenteResponseDTO(
    
    Long id,
    String compatibilidade,
    Integer distanciaFocal,
    Integer diametroFiltro,
    String montagem,
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    MarcaResponseDTO marca,
    String nomeImagem
    
) {
    public LenteResponseDTO (Lente lente){
        this(

            lente.getId(),
            lente.getCompatibilidade(),
            lente.getDistanciaFocal(),
            lente.getDiametroFiltro(),
            lente.getMontagem(),
            lente.getNomeModelo(),
            lente.getPreco(),
            lente.getMaterial(),
            lente.getDimensoes(),
            new MarcaResponseDTO(lente.getMarca().getId(), lente.getMarca().getMarca()),
            lente.getNomeImagem()
        );
    }
}  

