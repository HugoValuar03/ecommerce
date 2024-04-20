package br.unitins.topicos1.dto;

import java.time.LocalDateTime;

import br.unitins.topicos1.model.Lente;
import br.unitins.topicos1.model.Marca;
import br.unitins.topicos1.model.Status;

public record LentesResponseDTO(
    Long idProduto,
    String compatibilidade,
    Integer distandicaFocal,
    Integer diametroFiltro,
    String montagem,
    String nomeProduto,
    Double preco,
    String material,
    String dimensoes,
    String nomeModelo,
    Marca marca,
    String responsavel,
    String categoria,
    Status status,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao

) {
    public static LentesResponseDTO valueOf(Lente lentes){
        return new LentesResponseDTO(
            lentes.getCadastro().getId(),
            lentes.getCompatibilidade(),
            lentes.getDistanciaFocal(),
            lentes.getDiametroFiltro(),
            lentes.getMontagem(),
            lentes.getNomeProduto(),
            lentes.getPreco(),
            lentes.getMaterial(),
            lentes.getDimensoes(),
            lentes.getNomeModelo(),
            lentes.getMarca(),
            lentes.getCadastro().getResponsavel(),
            lentes.getCadastro().getCategoria(),
            lentes.getCadastro().getStatus(),
            lentes.getCadastro().getDataAlteracao(),
            lentes.getCadastro().getDataCadastro()
        );
    }
}  

