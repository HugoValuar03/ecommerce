package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Lente;
import br.unitins.topicos1.model.Marca;

public record LentesResponseDTO(
    Long id,
    String compatibilidade,
    Integer distanciaFocal,
    Integer diametroFiltro,
    String montagem,
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    Marca marca
    
) {
    public static LentesResponseDTO valueOf(Lente lentes){
        return new LentesResponseDTO(

            lentes.getId(),
            lentes.getCompatibilidade(),
            lentes.getDistanciaFocal(),
            lentes.getDiametroFiltro(),
            lentes.getMontagem(),
            lentes.getNomeModelo(),
            lentes.getPreco(),
            lentes.getMaterial(),
            lentes.getDimensoes(),
            lentes.getMarca()
        );
    }
}  

