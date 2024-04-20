package br.unitins.topicos1.dto;

import java.time.LocalDateTime;

import br.unitins.topicos1.model.Marca;
import br.unitins.topicos1.model.Status;

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
    String nomeModelo,
    Status status,
    String categoria,
    String responsavel,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao

) {}