package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Bolsas.Cor;
import br.unitins.topicos1.model.Bolsas.Modelo;

public record BolsasDTO(
    String id,
    String nome,
    Double valor,
    String marca,
    Modelo modelo,
    Cor cor,
    Integer largura,
    Integer altura
){

}