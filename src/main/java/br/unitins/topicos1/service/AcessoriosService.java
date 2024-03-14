package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.AcessoriosDTO;
import br.unitins.topicos1.dto.AcessoriosResponseDTO;
import jakarta.validation.Valid;

public interface AcessoriosService {
    
    public AcessoriosResponseDTO create(@Valid AcessoriosDTO dto); 
    public void update(Long id, AcessoriosDTO dto); 
    public void delete(Long id); 
    public AcessoriosResponseDTO findById(Long id);
    public List<AcessoriosResponseDTO> findAll();
    public List<AcessoriosResponseDTO> findByNome(String nome);
    
}
