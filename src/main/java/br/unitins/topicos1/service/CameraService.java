package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CameraDTO;
import br.unitins.topicos1.dto.CameraResponseDTO;
import jakarta.validation.Valid;

public interface CameraService {

    public CameraResponseDTO create(@Valid CameraDTO dto); 
    public void update(Long id, CameraDTO dto); 
    public void delete(Long id); 
    public CameraResponseDTO findById(Long id);
    public List<CameraResponseDTO> findAll();
    public List<CameraResponseDTO> findByNomeProduto(String nomeProduto);
    public List<CameraResponseDTO> findByMarca(String marca);
}
