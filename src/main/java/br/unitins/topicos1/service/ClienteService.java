package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.UpdateEmailDTO;
import br.unitins.topicos1.dto.UpdateNomeDTO;
import br.unitins.topicos1.dto.UpdateSenhaDTO;
import br.unitins.topicos1.dto.UpdateUsernameDTO;
import jakarta.validation.Valid;

public interface ClienteService {
    
    public ClienteResponseDTO create(@Valid ClienteDTO dto); 
    public void update(Long id, ClienteDTO dto); 
    public void delete(Long id); 
    public ClienteResponseDTO findById(Long id);
    public List<ClienteResponseDTO> findAll();
    public List<ClienteResponseDTO> findByCpf(String cpf);
    public PessoaResponseDTO login(String username, String senha);
    public ClienteResponseDTO updateEmail(Long id, UpdateEmailDTO email);
    public ClienteResponseDTO updateNome(Long id, UpdateNomeDTO nome);
    public ClienteResponseDTO updateUsername(Long id, UpdateUsernameDTO username);
    public ClienteResponseDTO updateSenha(Long id, UpdateSenhaDTO senha);


}
