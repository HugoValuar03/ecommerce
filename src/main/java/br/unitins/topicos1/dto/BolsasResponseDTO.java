package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Bolsas;
import br.unitins.topicos1.model.Bolsas.Cor;
import br.unitins.topicos1.model.Bolsas.Modelo;

public record BolsasResponseDTO(
    Double preco,
    String nome,
    String marca,
    Modelo modelo,
    Cor cor,
    Integer largura,
    Integer altura
) {

    public static BolsasResponseDTO valueof(Bolsas bolsas){
        return new BolsasResponseDTO(
        bolsas.getPreco(),
        bolsas.getNomeProduto(),
        bolsas.getMarca(),
        bolsas.getModelo(),
        bolsas.getCor(),
        bolsas.getLargura(),
        bolsas.getAltura()
        );
    }
} 
