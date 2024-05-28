package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Camera;

public record CameraResponseDTO(

    Long id,
    String conectividade,
    String resolucao,
    Boolean telaArticulavel,
    Boolean telaSensivelToque,
    String tela,
    String iso,
    Boolean flashPopUp,
    Integer garantia,
    MarcaResponseDTO marca,
    String nomeImagem

) {

    public static CameraResponseDTO valueof(Camera camera){
        return new CameraResponseDTO(
            camera.getId(),
            camera.getConectividade(),
            camera.getResolucao(),
            camera.getTelaArticulavel(),
            camera.getTelaSensivelToque(),
            camera.getTipoTela(),
            camera.getIso(),
            camera.getFlashPopUp(),
            camera.getGarantia(),
            MarcaResponseDTO.valueOf(camera.getMarca()),
            camera.getNomeImagem()
        );
    }
}
