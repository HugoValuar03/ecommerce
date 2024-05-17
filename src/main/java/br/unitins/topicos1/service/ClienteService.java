package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface ClienteService {
    
    public ClienteResponseDTO create(@Valid ClienteDTO dto); 
    public void update(Long id, ClienteDTO dto); 
    public void delete(Long id); 
    public ClienteResponseDTO findById(Long id);
    public List<ClienteResponseDTO> findAll();
    public List<ClienteResponseDTO> findByCpf(String cpf);
    public UsuarioResponseDTO login(String username, String senha);


}
