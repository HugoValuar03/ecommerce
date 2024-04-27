package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.MarcaDTO;
import br.unitins.topicos1.dto.MarcaResponseDTO;
import br.unitins.topicos1.model.Marca;
import br.unitins.topicos1.repository.MarcaRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class MarcaServiceImpl implements MarcaService{

    @Inject
    private MarcaRepository marcaRepository;

    @Override
    @Transactional
    public MarcaResponseDTO create(@Valid MarcaDTO dto) {
        validarNome(dto.nome());

        Marca marca = new Marca();

        marca.setNome(dto.nome());

        marcaRepository.persist(marca);
        return MarcaResponseDTO.valueOf(marca);    
    }

    public void validarNome(String nome) {
        Marca marca = marcaRepository.validarNome(nome);
        if (marca != null)
            throw  new ValidationException("nome", "O nome '"+ nome +"' já existe.");
    }

    @Override
    @Transactional 
    public void update(Long id, MarcaDTO dto) {
        Marca marcaBanco = marcaRepository.findById(id);

        marcaBanco.setNome(dto.nome());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        marcaRepository.deleteById(id);
    }

    @Override
    public MarcaResponseDTO findById(Long id) {
        return MarcaResponseDTO.valueOf(marcaRepository.findById(id));
    }

    @Override
    public List<MarcaResponseDTO> findAll() {
        return marcaRepository
        .listAll()
        .stream()
        .map(e -> MarcaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<MarcaResponseDTO> findByNome(String nome) {
        return marcaRepository
        .findByNome(nome)
        .stream()
        .map(e -> MarcaResponseDTO.valueOf(e)).toList();    
    }
    
}
