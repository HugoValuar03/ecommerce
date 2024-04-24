package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.TelefoneRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class TelefoneServiceImpl implements TelefoneService {

    @Inject
    private TelefoneRepository telefoneRepository;

    @Override
    @Transactional
    public TelefoneResponseDTO create(@Valid TelefoneDTO dto) {
        Telefone telefone = new Telefone();

        telefone.setCodigoArea(dto.codigoArea());
        telefone.setNumero(dto.numero());

        telefoneRepository.persist(telefone);
        return TelefoneResponseDTO.valueOf(telefone); 
    }

    @Override
    @Transactional
    public void update(Long id, TelefoneDTO dto) {
        Telefone telefoneBanco = telefoneRepository.findById(id);

        telefoneBanco.setCodigoArea(dto.codigoArea());
        telefoneBanco.setNumero(dto.numero());
    }

    @Override
    public void delete(Long id) {
        telefoneRepository.deleteById(id);
    }

    @Override
    public TelefoneResponseDTO findById(Long id) {
        return TelefoneResponseDTO.valueOf(telefoneRepository.findById(id));
    }

    @Override
    public List<TelefoneResponseDTO> findAll() {
        return telefoneRepository
        .listAll()
        .stream()
        .map(e -> TelefoneResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<TelefoneResponseDTO> findByCodigoArea(String codigoArea) {
        return telefoneRepository
        .findByCodigoArea(codigoArea)
        .stream()
        .map(e -> TelefoneResponseDTO.valueOf(e)).toList();
    }
    
}
