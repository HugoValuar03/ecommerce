package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Camera;
import br.unitins.topicos1.model.Marca;

public record CameraResponseDTO(

    String conectividade,
    String resolucao,
    Boolean telaArticulavel,
    Boolean telaSensivelToque,
    String tela,
    String iso,
    Boolean flashPopUp,
    Integer garantia,
    String nomeImagem,
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    Marca marca

) {

    public static CameraResponseDTO valueof(Camera camera){
        
        return new CameraResponseDTO(
            camera.getConectividade(),
            camera.getResolucao(),
            camera.getTelaArticulavel(),
            camera.getTelaSensivelToque(),
            camera.getTipoTela(),
            camera.getIso(),
            camera.getFlashPopUp(),
            camera.getGarantia(),
            camera.getNomeImagem(),
            camera.getNomeModelo(),
            camera.getPreco(),
            camera.getMaterial(),
            camera.getDimensoes(),
            camera.getMarca()

        );
    }
}
