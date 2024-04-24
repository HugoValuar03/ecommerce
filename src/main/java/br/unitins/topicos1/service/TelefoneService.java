package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;
import jakarta.validation.Valid;

public interface TelefoneService {
    public TelefoneResponseDTO create(@Valid TelefoneDTO dto); 
    public void update(Long id, TelefoneDTO dto); 
    public void delete(Long id); 
    public TelefoneResponseDTO findById(Long id);
    public List<TelefoneResponseDTO> findAll();
    public List<TelefoneResponseDTO> findByCodigoArea(String codigoArea);
}