package br.unitins.topicos1.dto;

import java.time.LocalDateTime;

import br.unitins.topicos1.model.Camera;
import br.unitins.topicos1.model.Marca;
import br.unitins.topicos1.model.Status;

public record CameraResponseDTO(

    Long idCamera,
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

) {

    public static CameraResponseDTO valueof(Camera camera){
        return new CameraResponseDTO(
            camera.getCadastro().getId(),
            camera.getMarca(),
            camera.getConectividade(),
            camera.getResolucao(),
            camera.getTelaArticulavel(),
            camera.getTelaSensivelToque(),
            camera.getTipoTela(),
            camera.getIso(),
            camera.getFlashPopUp(),
            camera.getGarantia(),
            camera.getNomeProduto(),
            camera.getPreco(),
            camera.getMaterial(),
            camera.getDimensoes(),
            camera.getNomeModelo(),
            camera.getCadastro().getStatus(),
            camera.getCadastro().getResponsavel(),
            camera.getCadastro().getCategoria(),
            camera.getCadastro().getDataAlteracao(),
            camera.getCadastro().getDataCadastro()
        );
    }
}
