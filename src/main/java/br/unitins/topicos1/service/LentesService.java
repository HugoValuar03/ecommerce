package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.dto.LentesResponseDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import jakarta.validation.Valid;

public interface LentesService {

    public LentesResponseDTO create(@Valid LentesDTO dto); 
    public void update(Long id, LentesDTO dto); 
    public void delete(Long id); 
    public LentesResponseDTO findById(Long id);
    public List<PessoaResponseDTO> findAll();
    public List<PessoaResponseDTO> findByNome(String nome);
    public List<PessoaResponseDTO> findByMarca(String marca);

}
