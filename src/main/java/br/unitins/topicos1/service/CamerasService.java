package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.CamerasDTO;
import br.unitins.topicos1.dto.CamerasResponseDTO;
import jakarta.validation.Valid;

public interface CamerasService {

    public CamerasResponseDTO create(@Valid CamerasDTO dto); 
    public void update(Long id, CamerasDTO dto); 
    public void delete(Long id); 
    public CamerasResponseDTO findById(Long id);
    public List<CamerasResponseDTO> findAll();
    public List<CamerasResponseDTO> findByNome(String nome);
    public List<CamerasResponseDTO> findByMarca(String marca);

}
