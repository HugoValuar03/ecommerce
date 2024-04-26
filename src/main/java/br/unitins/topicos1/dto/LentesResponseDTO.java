package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Lente;
import br.unitins.topicos1.model.Marca;

public record LentesResponseDTO(
    Long idProduto,
    String compatibilidade,
    Integer distandicaFocal,
    Integer diametroFiltro,
    String montagem,
    Double preco,
    String material,
    String dimensoes,
    String nomeModelo,
    Marca marca

) {
    public static LentesResponseDTO valueOf(Lente lentes){
        return new LentesResponseDTO(

            lentes.getId(),
            lentes.getCompatibilidade(),
            lentes.getDistanciaFocal(),
            lentes.getDiametroFiltro(),
            lentes.getMontagem(),
            lentes.getPreco(),
            lentes.getMaterial(),
            lentes.getDimensoes(),
            lentes.getNomeModelo(),
            lentes.getMarca()
        );
    }
}  

