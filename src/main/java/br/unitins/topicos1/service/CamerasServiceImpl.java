package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CamerasDTO;
import br.unitins.topicos1.dto.CamerasResponseDTO;
import br.unitins.topicos1.model.Cameras;
import br.unitins.topicos1.repository.CamerasRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

public class CamerasServiceImpl implements CamerasService{

    @Inject
    public CamerasRepository camerasRepository;

    @Override
    @Transactional
    public CamerasResponseDTO create(@Valid CamerasDTO dto) {
        Cameras cameras = new Cameras();

        cameras.setNomeProduto(dto.nomeProduto());
        cameras.setBateria(dto.bateria());
        cameras.setFormatoAudio(dto.formatoAudio());
        cameras.setFormatoImagem(dto.formatoImagem());
        cameras.setFormatoVideo(dto.formatoVideo());
        cameras.setIso(dto.iso());
        cameras.setLente(dto.lentes());
        cameras.setMarca(dto.marca());
        cameras.setObturador(dto.obturador());
        cameras.setPreco(dto.preco());
        cameras.setProcessador(dto.processador());
        cameras.setSensor(dto.sensor());

        camerasRepository.persist(cameras);

        return CamerasResponseDTO.valueof(cameras);
    }

    @Override
    @Transactional
    public void update(Long id, CamerasDTO dto) {
        Cameras estadoBanco =  camerasRepository.findById(id);

        estadoBanco.setNomeProduto(dto.nomeProduto());
        estadoBanco.setMarca(dto.marca());
        estadoBanco.setBateria(dto.bateria());
        estadoBanco.setFormatoAudio(dto.formatoAudio());
        estadoBanco.setFormatoImagem(dto.formatoImagem());
        estadoBanco.setFormatoVideo(dto.formatoVideo());
        estadoBanco.setIso(dto.iso());
        estadoBanco.setLente(dto.lentes());
        estadoBanco.setObturador(dto.obturador());
        estadoBanco.setPreco(dto.preco());
        estadoBanco.setProcessador(dto.processador());
        estadoBanco.setSensor(dto.sensor());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        camerasRepository.deleteById(id);
    }

    @Override
    public CamerasResponseDTO findById(Long id) {
        return CamerasResponseDTO.valueof(camerasRepository.findById(id));
    }

    @Override
    public List<CamerasResponseDTO> findAll() {
        return camerasRepository
        .listAll()
        .stream()
        .map(e -> CamerasResponseDTO.valueof(e)).toList();
    }

    @Override
    public List<CamerasResponseDTO> findByNome(String nome) {
        return camerasRepository
        .findByNomeProduto(nome)
        .stream()
        .map(e -> CamerasResponseDTO.valueof(e)).toList();
    }

    @Override
    public List<CamerasResponseDTO> findByMarca(String marca) {
        return camerasRepository
        .findByMarca(marca)
        .stream()
        .map(e -> CamerasResponseDTO.valueof(e)).toList();
    }
    
}
