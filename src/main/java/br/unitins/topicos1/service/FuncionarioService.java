package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import jakarta.validation.Valid;

public interface FuncionarioService {
    
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto); 
    public void update(Long id, FuncionarioDTO dto); 
    public void delete(Long id); 
    public FuncionarioResponseDTO findById(Long id);
    public List<FuncionarioResponseDTO> findAll();
    public List<FuncionarioResponseDTO> findByCargo(String cargo);
    public List<FuncionarioResponseDTO> findBySigla(String sigla);
    public List<FuncionarioResponseDTO> findByNome(String nome);

}
