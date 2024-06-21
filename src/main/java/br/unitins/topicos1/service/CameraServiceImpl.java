package br.unitins.topicos1.service;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.dto.CameraResponseDTO;
import br.unitins.topicos1.model.Camera;
import br.unitins.topicos1.model.Marca;
import br.unitins.topicos1.repository.CameraRepository;
import br.unitins.topicos1.repository.MarcaRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CameraServiceImpl implements CameraService{

    @Inject
    public CameraRepository cameraRepository;

    @Inject
    public MarcaRepository marcaRepository;
    
    @Override
    @Transactional
    public CameraResponseDTO create(@Valid CameraDTO dto) {
        validarModelo(dto.produto().nomeModelo());
        Camera camera = new Camera();
        Marca marca = new Marca();
        
        marca.setMarca(dto.produto().marca().marca());

        marcaRepository.persist(marca);

        camera.setMarca(marca);
        camera.setConectividade(dto.conectividade());
        camera.setResolucao(dto.resolucao());
        camera.setTelaArticulavel(dto.telaArticulavel());
        camera.setTelaSensivelToque(dto.telaSensivelToque());
        camera.setTipoTela(dto.tela());
        camera.setIso(dto.iso());
        camera.setFlashPopUp(dto.flashPopUp());
        camera.setGarantia(dto.garantia());
        camera.setPreco(dto.produto().preco());
        camera.setMaterial(dto.produto().material());
        camera.setDimensoes(dto.produto().dimensoes());
        camera.setNomeModelo(dto.produto().nomeModelo());
        camera.setDataCadastro(LocalDateTime.now());  

        cameraRepository.persist(camera);
        return new CameraResponseDTO(camera);
    }

    public void validarModelo(String modelo) {
        Camera camera = cameraRepository.validarModelo(modelo);
        if (camera != null)
            throw  new ValidationException("nomeModelo", "O modelo '"+ modelo +"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, CameraDTO dto) {
        Camera cameraBanco =  cameraRepository.findById(id);
        Marca marcaBanco = marcaRepository.findById(id);
        
        marcaBanco.setMarca(dto.produto().marca().marca());

        cameraBanco.setMarca(marcaBanco);
        cameraBanco.setConectividade(dto.conectividade());
        cameraBanco.setResolucao(dto.resolucao());
        cameraBanco.setTelaArticulavel(dto.telaArticulavel());
        cameraBanco.setTelaSensivelToque(dto.telaSensivelToque());
        cameraBanco.setTipoTela(dto.tela());
        cameraBanco.setIso(dto.iso());
        cameraBanco.setFlashPopUp(dto.flashPopUp());
        cameraBanco.setGarantia(dto.garantia());
        cameraBanco.setPreco(dto.produto().preco());
        cameraBanco.setMaterial(dto.produto().material());
        cameraBanco.setDimensoes(dto.produto().dimensoes());
        cameraBanco.setNomeModelo(dto.produto().nomeModelo());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        cameraRepository.deleteById(id);
    }

    @Override
    public CameraResponseDTO findById(Long id) {
        return new CameraResponseDTO(cameraRepository.findById(id));
    }

    @Override
    public List<CameraResponseDTO> findAll() {
        return cameraRepository
        .listAll()
        .stream()
        .map(e -> new CameraResponseDTO(e))
        .toList();
    }

    @Override
    public List<CameraResponseDTO> findByNomeProduto(String nomeProduto) {
        return cameraRepository
        .findByNomeProduto(nomeProduto)
        .stream()
        .map(e -> new CameraResponseDTO(e)).toList();
    }

    @Override
    public List<CameraResponseDTO> findByMarca(String marca) {
        return cameraRepository
        .findByMarca(marca)
        .stream()
        .map(e -> new CameraResponseDTO(e)).toList();
    }
}
