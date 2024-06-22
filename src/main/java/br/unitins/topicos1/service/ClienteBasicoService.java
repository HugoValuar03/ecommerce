package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteBasicoDTO;
import br.unitins.topicos1.dto.ClienteBasicoResponseDTO;
import jakarta.validation.Valid;

public interface ClienteBasicoService {
    public ClienteBasicoResponseDTO create(@Valid ClienteBasicoDTO clienteBasico);
    public List<ClienteBasicoResponseDTO> findAll();
}
