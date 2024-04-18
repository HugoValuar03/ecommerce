package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cameras;
import br.unitins.topicos1.model.Marca;

public record CamerasResponseDTO(

    Long idCameras,
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

) {

    public static CamerasResponseDTO valueof(Cameras cameras){
        return new CamerasResponseDTO(
            cameras.getIdCameras(),
            cameras.getMarca(),
            cameras.getConectividade(),
            cameras.getResolucao(),
            cameras.getTelaArticulavel(),
            cameras.getTelaSensivelToque(),
            cameras.getTipoTela(),
            cameras.getIso(),
            cameras.getFlashPopUp(),
            cameras.getGarantia(),
            cameras.getNomeProduto(),
            cameras.getPreco(),
            cameras.getMaterial(),
            cameras.getDimensoes(),
            cameras.getNomeModelo()
        );
    }

}
