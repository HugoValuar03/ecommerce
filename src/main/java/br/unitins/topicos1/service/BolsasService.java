package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.BolsasDTO;
import br.unitins.topicos1.dto.BolsasResponseDTO;
import jakarta.validation.Valid;

public interface BolsasService {

    public BolsasResponseDTO create(@Valid BolsasDTO dto); 
    public void update(Long id, BolsasDTO dto); 
    public void delete(Long id); 
    public BolsasResponseDTO findById(Long id);
    public List<BolsasResponseDTO> findAll();
    public List<BolsasResponseDTO> findByMarca(String marca);
    public List<BolsasResponseDTO> findByNome(String nome);

}
