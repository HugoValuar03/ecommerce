package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Bolsas.Cor;
import br.unitins.topicos1.model.Bolsas.Modelo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BolsasDTO(

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 65, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    String nome,

    @NotBlank(message = "Preco é obrigatório")
    @Size(min = 4, max = 10, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    Double valor,

    @NotBlank(message = "Marca da bolsa necessario")
    @Size(min = 1, max = 30, message = "Deve ter entre 3 e 10 caracteres")
    String marca,

    @NotBlank(message = "Modelo necessario")
    @Size(min = 1, max = 30, message = "Deve ter entre 1 e 30 caracteres")
    Modelo modelo,

    @NotBlank(message = "Cor necessaria")
    @Size(min = 1, max = 10, message = "Deve ter entre 1 e 10 caracteres")
    Cor cor,

    @NotBlank(message = "Largura necessaria")
    @Size(min = 1, max = 3, message = "Deve ter entre 1 e 3 caracteres")
    Integer largura,

    @NotBlank(message = "Altura necessaria")
    @Size(min = 1, max = 3, message = "Deve ter entre 1 e 3 caracteres")
    Integer altura
){

}