package br.unitins.topicos1.dto;

import java.time.LocalDateTime;

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
    String nomeImagem,
    String nomeModelo,
    Double preco,
    String material,
    String dimensoes,
    LocalDateTime dataCadastro,
    MarcaResponseDTO marca

) {

    public CameraResponseDTO(Camera camera){
        
        this(
            camera.getId(),
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
            camera.getDataCadastro(),
            new MarcaResponseDTO(camera.getMarca().getId(), camera.getMarca().getMarca())

        );
    }
}
