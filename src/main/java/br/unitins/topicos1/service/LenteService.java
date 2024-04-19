package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.dto.LentesResponseDTO;
import jakarta.validation.Valid;

public interface LenteService {

    public LentesResponseDTO create(@Valid LentesDTO dto); 
    public void update(Long id, LentesDTO dto); 
    public void delete(Long id); 
    public LentesResponseDTO findById(Long id);
    public List<LentesResponseDTO> findAll();
    public List<LentesResponseDTO> findByMarca(String marca);

}
