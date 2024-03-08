package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Bolsas.Marca;
import br.unitins.topicos1.model.Cameras.Bateria;
import br.unitins.topicos1.model.Cameras.FormatoAudio;
import br.unitins.topicos1.model.Cameras.FormatoImagem;
import br.unitins.topicos1.model.Cameras.FormatoVideo;
import br.unitins.topicos1.model.Cameras.Iso;
import br.unitins.topicos1.model.Cameras.Lentes;
import br.unitins.topicos1.model.Cameras.Obturador;
import br.unitins.topicos1.model.Cameras.Processador;
import br.unitins.topicos1.model.Cameras.Sensor;

public record CamerasDTO(String nomeProduto, String preco, Marca marca, Sensor sensor, Bateria bateria, FormatoAudio formatoAudio, FormatoImagem formatoImagem, FormatoVideo formatoVideo, Iso iso, Lentes lentes, Obturador obturador, Processador processador, String resolucao) {}