package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cameras;

public record CamerasResponseDTO (

    String marca,
    Cameras.Sensor sensor,
    Cameras.Bateria bateria,
    Cameras.FormatoAudio formatoAudio,
    Cameras.FormatoImagem formatoImagem,
    Cameras.FormatoVideo formatoVideo,
    Cameras.Iso iso,
    Cameras.Lentes lentes,
    Cameras.Obturador obturador,
    Cameras.Processador processador,
    String resolucao


) {

    public static CamerasResponseDTO valueof(Cameras cameras){
        return new CamerasResponseDTO(
            cameras.getMarca(), 
            cameras.getSensor(), 
            cameras.getBateria(), 
            cameras.getFormatoAudio(), 
            cameras.getFormatoImagem(), 
            cameras.getFormatoVideo(), 
            cameras.getIso(), 
            cameras.getLente(),
            cameras.getObturador(), 
            cameras.getProcessador(),
            cameras.getResolucao()
        );
    }

}
