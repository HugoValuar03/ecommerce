package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LenteDTO;
import br.unitins.topicos1.dto.LenteResponseDTO;
import br.unitins.topicos1.model.Lente;
import br.unitins.topicos1.model.Marca;
import br.unitins.topicos1.repository.LenteRepository;
import br.unitins.topicos1.repository.MarcaRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class LenteServiceImpl implements LenteService {

    @Inject
    private LenteRepository lenteRepository;

    @Inject 
    private MarcaRepository marcaRepository;

    @Override
    @Transactional
    public LenteResponseDTO create(@Valid LenteDTO dto) {
        validarModelo(dto.nomeModelo());
        Lente lente = new Lente();
        Marca marca = new Marca();
        
        marca.setMarca(dto.marca().marca());

        marcaRepository.persist(marca);

        lente.setMarca(marca);
        lente.setCompatibilidade(dto.compatibilidade());
        lente.setDistanciaFocal(dto.distanciaFocal());
        lente.setDiametroFiltro(dto.diametroFiltro());
        lente.setMontagem(dto.montagem());
        lente.setPreco(dto.preco());
        lente.setMaterial(dto.material());
        lente.setDimensoes(dto.dimensoes());
        lente.setNomeModelo(dto.nomeModelo());    

        lenteRepository.persist(lente);
        return new LenteResponseDTO(lente);    
    }

    @Override
    @Transactional
    public void update(Long id, LenteDTO dto) {
        Lente lenteBanco =  lenteRepository.findById(id);
        Marca marcaBanco =  marcaRepository.findById(id);

        marcaBanco.setMarca(dto.marca().marca());

        lenteBanco.setMarca(marcaBanco);
        lenteBanco.setCompatibilidade(dto.compatibilidade());
        lenteBanco.setDistanciaFocal(dto.distanciaFocal());
        lenteBanco.setDiametroFiltro(dto.diametroFiltro());
        lenteBanco.setMontagem(dto.montagem());
        lenteBanco.setPreco(dto.preco());
        lenteBanco.setMaterial(dto.material());
        lenteBanco.setDimensoes(dto.dimensoes());
        lenteBanco.setNomeModelo(dto.nomeModelo());

    }

    public void validarModelo(String modelo) {
        Lente lente = lenteRepository.validarModelo(modelo);
        if (lente != null)
            throw  new ValidationException("nomeModelo", "O modelo '"+ modelo +"' já existe.");
    }

    @Override
    @Transactional
    public void delete(Long id) {
        lenteRepository.deleteById(id);
    }

    @Override
    public LenteResponseDTO findById(Long id) {
        return new LenteResponseDTO(lenteRepository.findById(id));
    }

    @Override
    public List<LenteResponseDTO> findAll() {
        return lenteRepository
        .listAll()
        .stream()
        .map(e -> new LenteResponseDTO(e)).toList();
    }

    @Override
    public List<LenteResponseDTO> findByMontagem(String montagem) {
        return lenteRepository
        .findByMontagem(montagem)
        .stream()
        .map(e -> new LenteResponseDTO(e)).toList();
    }
   
}
