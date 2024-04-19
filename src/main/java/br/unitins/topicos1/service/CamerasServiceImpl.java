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

        cameras.setConectividade(dto.conectividade());
        cameras.setResolucao(dto.resolucao());
        cameras.setTelaArticulavel(dto.telaArticulavel());
        cameras.setTelaSensivelToque(dto.telaSensivelToque());
        cameras.setTipoTela(dto.tela());
        cameras.setIso(dto.iso());
        cameras.setFlashPopUp(dto.flashPopUp());
        cameras.setGarantia(dto.garantia());
        cameras.setNomeProduto(dto.nomeProduto());
        cameras.setPreco(dto.preco());
        cameras.setMaterial(dto.material());
        cameras.setDimensoes(dto.dimensoes());
        cameras.setNomeModelo(dto.nomeModelo());

        camerasRepository.persist(cameras);
        return CamerasResponseDTO.valueof(cameras);
    }

    @Override
    @Transactional
    public void update(Long id, CamerasDTO dto) {
        Cameras camerasBanco =  camerasRepository.findById(id);

        camerasBanco.setConectividade(dto.conectividade());
        camerasBanco.setResolucao(dto.resolucao());
        camerasBanco.setTelaArticulavel(dto.telaArticulavel());
        camerasBanco.setTelaSensivelToque(dto.telaSensivelToque());
        camerasBanco.setTipoTela(dto.tela());
        camerasBanco.setIso(dto.iso());
        camerasBanco.setFlashPopUp(dto.flashPopUp());
        camerasBanco.setGarantia(dto.garantia());
        camerasBanco.setNomeProduto(dto.nomeProduto());
        camerasBanco.setPreco(dto.preco());
        camerasBanco.setMaterial(dto.material());
        camerasBanco.setDimensoes(dto.dimensoes());
        camerasBanco.setNomeModelo(dto.nomeModelo());
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
    public List<CamerasResponseDTO> findByNomeProduto(String nomeProduto) {
        return camerasRepository
        .findByNomeProduto(nomeProduto)
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
