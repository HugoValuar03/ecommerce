package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Lentes.Abertura;
import br.unitins.topicos1.model.Lentes.Compatibilidade;
import br.unitins.topicos1.model.Lentes.DistanciaFocal;
import br.unitins.topicos1.model.Lentes.TipoLente;
import br.unitins.topicos1.model.Lentes.TipoMontagem;

public record LentesDTO(
    String nomeProduto, 
    Double preco, 
    TipoMontagem tipoMontagem, 
    String marcaLente, 
    DistanciaFocal distanciaFocal, 
    Abertura abertura, 
    TipoLente lentes, 
    Compatibilidade compatibilidade, 
    String dimensoes, 
    Double peso
) {}

