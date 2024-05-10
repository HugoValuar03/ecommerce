package br.unitins.topicos1.dto;

public record CameraDTO(

    String conectividade,
    String resolucao,
    Boolean telaArticulavel,
    Boolean telaSensivelToque,
    String tela,
    String iso,
    Boolean flashPopUp,
    Integer garantia,
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    Long marca

) {}