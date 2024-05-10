package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Marca;

public record LentesDTO(
    
    String compatibilidade,
    Integer distanciaFocal,
    Integer diametroFiltro,
    String montagem,
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    Marca marca

) {}
