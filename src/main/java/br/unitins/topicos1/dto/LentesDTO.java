package br.unitins.topicos1.dto;

import java.time.LocalDateTime;

import br.unitins.topicos1.model.Marca;
import br.unitins.topicos1.model.Status;

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
    String nomeModelo,
    String responsavel,
    String categoria,
    Status status,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao
    
) {}

