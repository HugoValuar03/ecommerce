package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Marca;

public record LentesDTO(
    
    String compatibilidade,
    Marca marca,
    Integer distandicaFocal,
    Integer diametroFiltro,
    String montagem,
    String nomeProduto,
    Double preco,
    String material,
    String dimensoes,
    String nomeModelo
    
) {}

