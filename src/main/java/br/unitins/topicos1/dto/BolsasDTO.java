package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Bolsas.Cor;
import br.unitins.topicos1.model.Bolsas.Marca;
import br.unitins.topicos1.model.Bolsas.Modelo;

public record BolsasDTO(
    String id,
    String nome,
    Double valor,
    Marca marca,
    Modelo modelo,
    Cor cor,
    Double largura,
    Double altura
){

}