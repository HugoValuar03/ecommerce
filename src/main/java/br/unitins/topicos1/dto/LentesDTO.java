package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Marca;

public record LentesDTO(
    
    String compatibilidade,
    Integer distandicaFocal,
    Integer diametroFiltro,
    String montagem,
    Double preco,
    String material,
    String dimensoes,
    String nomeModelo,
    Marca marca
    
) {}

