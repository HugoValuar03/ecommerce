package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Bolsas;
import br.unitins.topicos1.model.Bolsas.Cor;
import br.unitins.topicos1.model.Bolsas.Marca;
import br.unitins.topicos1.model.Bolsas.Modelo;

public record BolsasResponseDTO(
    Double valor,
    String nome,
    Marca marca,
    Modelo modelo,
    Cor cor,
    Double largura,
    Double altura
) {

    public static BolsasResponseDTO valueof(Bolsas bolsas){
        return new BolsasResponseDTO(
        bolsas.getValor(),
        bolsas.getNome(),
        bolsas.getMarca(),
        bolsas.getModelo(),
        bolsas.getCor(),
        bolsas.getLargura(),
        bolsas.getAltura()
        );
    }
} 
