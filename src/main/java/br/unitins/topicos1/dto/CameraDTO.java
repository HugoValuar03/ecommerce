package br.unitins.topicos1.dto;

import java.time.LocalDateTime;

public record CameraDTO(

    String conectividade,
    String resolucao,
    Boolean telaArticulavel,
    Boolean telaSensivelToque,
    String tela,
    String iso,
    Boolean flashPopUp,
    Integer garantia,
    ProdutoDTO produto,
    LocalDateTime dataCadastro
    
) {}