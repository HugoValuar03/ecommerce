package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.dto.CameraResponseDTO;
import br.unitins.topicos1.model.Camera;
import br.unitins.topicos1.repository.CameraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CameraServiceImpl implements CameraService{

    @Inject
    public CameraRepository cameraRepository;

    @Override
    @Transactional
    public CameraResponseDTO create(@Valid CameraDTO dto) {
        Camera camera = new Camera();

        camera.setConectividade(dto.conectividade());
        camera.setResolucao(dto.resolucao());
        camera.setTelaArticulavel(dto.telaArticulavel());
        camera.setTelaSensivelToque(dto.telaSensivelToque());
        camera.setTipoTela(dto.tela());
        camera.setIso(dto.iso());
        camera.setFlashPopUp(dto.flashPopUp());
        camera.setGarantia(dto.garantia());
        camera.setNomeProduto(dto.nomeProduto());
        camera.setMarca(dto.marca());
        camera.setPreco(dto.preco());
        camera.setMaterial(dto.material());
        camera.setDimensoes(dto.dimensoes());
        camera.setNomeModelo(dto.nomeModelo());
        camera.getCadastro().setDataAlteracao(dto.dataAlteracao());
        camera.getCadastro().setDataCadastro(dto.dataCadastro());
        camera.getCadastro().setStatus(dto.status());
        camera.getCadastro().setCategoria(dto.categoria());
        camera.getCadastro().setResponsavel(dto.responsavel());
        

        cameraRepository.persist(camera);
        return CameraResponseDTO.valueof(camera);
    }

    @Override
    @Transactional
    public void update(Long id, CameraDTO dto) {
        Camera cameraBanco =  cameraRepository.findById(id);

        
        cameraBanco.setConectividade(dto.conectividade());
        cameraBanco.setResolucao(dto.resolucao());
        cameraBanco.setTelaArticulavel(dto.telaArticulavel());
        cameraBanco.setTelaSensivelToque(dto.telaSensivelToque());
        cameraBanco.setTipoTela(dto.tela());
        cameraBanco.setIso(dto.iso());
        cameraBanco.setFlashPopUp(dto.flashPopUp());
        cameraBanco.setGarantia(dto.garantia());
        cameraBanco.setNomeProduto(dto.nomeProduto());
        cameraBanco.setPreco(dto.preco());
        cameraBanco.setMaterial(dto.material());
        cameraBanco.setDimensoes(dto.dimensoes());
        cameraBanco.setNomeModelo(dto.nomeModelo());
        cameraBanco.getCadastro().setDataAlteracao(dto.dataAlteracao());
        cameraBanco.getCadastro().setDataCadastro(dto.dataCadastro());
        cameraBanco.getCadastro().setStatus(dto.status());
        cameraBanco.getCadastro().setCategoria(dto.categoria());
        cameraBanco.getCadastro().setResponsavel(dto.responsavel());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cameraRepository.deleteById(id);
    }

    @Override
    public CameraResponseDTO findById(Long id) {
        return CameraResponseDTO.valueof(cameraRepository.findById(id));
    }

    @Override
    public List<CameraResponseDTO> findAll() {
        return cameraRepository
        .listAll()
        .stream()
        .map(e -> CameraResponseDTO.valueof(e)).toList();
    }

    @Override
    public List<CameraResponseDTO> findByNomeProduto(String nomeProduto) {
        return cameraRepository
        .findByNomeProduto(nomeProduto)
        .stream()
        .map(e -> CameraResponseDTO.valueof(e)).toList();
    }

    @Override
    public List<CameraResponseDTO> findByMarca(String marca) {
        return cameraRepository
        .findByMarca(marca)
        .stream()
        .map(e -> CameraResponseDTO.valueof(e)).toList();
    }
}