package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.UpdateEmailDTO;
import br.unitins.topicos1.dto.UpdateNomeDTO;
import br.unitins.topicos1.dto.UpdateSenhaDTO;
import br.unitins.topicos1.dto.UpdateUsernameDTO;
import jakarta.validation.Valid;

public interface FuncionarioService {
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto); 
    public void update(Long id, FuncionarioDTO dto); 
    public void delete(Long id); 
    public FuncionarioResponseDTO findById(Long id);
    public List<FuncionarioResponseDTO> findAll();
    public List<FuncionarioResponseDTO> findByCargo(String cargo);
    public PessoaResponseDTO login(String username, String senha);
    public FuncionarioResponseDTO updateEmail(Long id, UpdateEmailDTO email);
    public FuncionarioResponseDTO updateNome(Long id, UpdateNomeDTO nome);
    public FuncionarioResponseDTO updateUsername(Long id, UpdateUsernameDTO username);
    public FuncionarioResponseDTO updateSenha(Long id, UpdateSenhaDTO senha);
}
