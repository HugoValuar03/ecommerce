package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LenteDTO;
import br.unitins.topicos1.dto.LenteResponseDTO;
import jakarta.validation.Valid;

public interface LenteService {

    public LenteResponseDTO create(@Valid LenteDTO dto); 
    public void update(Long id, LenteDTO dto); 
    public void delete(Long id); 
    public LenteResponseDTO findById(Long id);
    public List<LenteResponseDTO> findAll();
    public List<LenteResponseDTO> findByMontagem(String montagem);

}
