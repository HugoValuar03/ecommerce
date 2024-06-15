package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.PessoaUpdateEmailDTO;
import br.unitins.topicos1.dto.PessoaUpdateNomeDTO;
import br.unitins.topicos1.dto.PessoaUpdateSenhaDTO;
import br.unitins.topicos1.dto.PessoaUpdateUsernameDTO;
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
    public PessoaResponseDTO updateEmail(Long id, PessoaUpdateEmailDTO email);
    public PessoaResponseDTO updateNome(Long id, PessoaUpdateNomeDTO nome);
    public PessoaResponseDTO updateUsername(Long id, PessoaUpdateUsernameDTO username);
    public PessoaResponseDTO updateSenha(Long id, PessoaUpdateSenhaDTO senha);
    
}
