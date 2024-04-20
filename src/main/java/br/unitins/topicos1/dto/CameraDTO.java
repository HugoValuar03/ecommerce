package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Marca;

public record CameraDTO(

    Marca marca,
    String conectividade,
    String resolucao,
    Boolean telaArticulavel,
    Boolean telaSensivelToque,
    String tela,
    String iso,
    Boolean flashPopUp,
    Integer garantia,
    String nomeProduto,
    Double preco,
    String material,
    String dimensoes,
    String nomeModelo

) {}