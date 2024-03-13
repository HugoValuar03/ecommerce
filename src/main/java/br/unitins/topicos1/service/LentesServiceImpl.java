package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.dto.LentesResponseDTO;
import br.unitins.topicos1.model.Lentes;
import br.unitins.topicos1.repository.LentesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class LentesServiceImpl implements LentesService {

    @Inject
    private LentesRepository lentesRepository;

    @Override
    public LentesResponseDTO create(@Valid LentesDTO dto) {

           Lentes lentes = new Lentes();
           
           lentes.setNomeProduto(dto.nomeProduto());
           lentes.setPreco(dto.preco());
           lentes.setMaterial(dto.material());
           lentes.setAbertura(dto.abertura());
           lentes.setCompatibilidade(dto.compatibilidade());
           lentes.setMarca(dto.marca());
           lentes.setDistanciaFocal(dto.distanciaFocal());
           lentes.setFornecedor(dto.fornecedor());
           lentes.setLente(dto.lentes());
           lentes.setPeso(dto.peso());
           lentes.setTipoMontagem(dto.tipoMontagem());
           lentes.setDistanciaFocal(dto.distanciaFocal());

           lentesRepository.persist(lentes);
           return LentesResponseDTO.valueOf(lentes);    
           
    
    }

    @Override
    @Transactional
    public void update(Long id, LentesDTO dto) {
        Lentes lentesBanco =  lentesRepository.findById(id);

        lentesBanco.setNomeProduto(dto.nomeProduto());
        lentesBanco.setPreco(dto.preco());
        lentesBanco.setMaterial(dto.material());
        lentesBanco.setAbertura(dto.abertura());
        lentesBanco.setCompatibilidade(dto.compatibilidade());
        lentesBanco.setMarca(dto.marca());
        lentesBanco.setFornecedor(dto.fornecedor());
        lentesBanco.setDimensoes(dto.dimensoes());
        lentesBanco.setLente(dto.lentes());
        lentesBanco.setPeso(dto.peso());
        lentesBanco.setTipoMontagem(dto.tipoMontagem());
        lentesBanco.setDistanciaFocal(dto.distanciaFocal());
    }

    @Override
    public void delete(Long id) {
        lentesRepository.deleteById(id);
    }

    @Override
    public LentesResponseDTO findById(Long id) {
        return LentesResponseDTO.valueOf(lentesRepository.findById(id));
    }

    @Override
    public List<LentesResponseDTO> findAll() {
        return lentesRepository
        .listAll()
        .stream()
        .map(e -> LentesResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<LentesResponseDTO> findByNome(String nome) {
        return lentesRepository
        .findByNome(nome)
        .stream()
        .map(e -> LentesResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<LentesResponseDTO> findByMarca(String marca) {
        return lentesRepository
        .findByMarca(marca)
        .stream()
        .map(e -> LentesResponseDTO.valueOf(e)).toList();
    }
    
}
