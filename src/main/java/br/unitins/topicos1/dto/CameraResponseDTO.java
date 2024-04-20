package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Camera;
import br.unitins.topicos1.model.Marca;

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
    String nomeModelo

) {

    public static CameraResponseDTO valueof(Camera camera){
        return new CameraResponseDTO(
            camera.getIdProduto(),
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
            camera.getNomeModelo()
        );
    }
}
