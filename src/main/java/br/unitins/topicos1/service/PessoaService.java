package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;

@ApplicationScoped
public interface PessoaService {

    public PessoaResponseDTO create(@Valid PessoaDTO dto); 
    public void update(Long id, PessoaDTO dto); 
    public void delete(Long id); 
    public PessoaResponseDTO findById(Long id);
    public List<PessoaResponseDTO> findBynome(String nome);
    public List<PessoaResponseDTO> findAll();
    
}
