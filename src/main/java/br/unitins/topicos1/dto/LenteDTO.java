package br.unitins.topicos1.dto;

public record LenteDTO(
    
    String compatibilidade,
    Integer distanciaFocal,
    Integer diametroFiltro,
    String montagem,
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    MarcaDTO marca

) {}
