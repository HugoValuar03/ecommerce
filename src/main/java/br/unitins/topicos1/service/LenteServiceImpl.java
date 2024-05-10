package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.dto.LentesResponseDTO;
import br.unitins.topicos1.model.Lente;
import br.unitins.topicos1.repository.LenteRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class LenteServiceImpl implements LenteService {

    @Inject
    private LenteRepository lentesRepository;

    @Override
    @Transactional
    public LentesResponseDTO create(@Valid LentesDTO dto) {
        validarModelo(dto.nomeModelo());
        Lente lentes = new Lente();
        
        lentes.setCompatibilidade(dto.compatibilidade());
        lentes.setDistanciaFocal(dto.distanciaFocal());
        lentes.setDiametroFiltro(dto.diametroFiltro());
        lentes.setMontagem(dto.montagem());
        lentes.setPreco(dto.preco());
        lentes.setMaterial(dto.material());
        lentes.setDimensoes(dto.dimensoes());
        lentes.setNomeModelo(dto.nomeModelo());    

        lentesRepository.persist(lentes);
        return LentesResponseDTO.valueOf(lentes);    
    }

    @Override
    @Transactional
    public void update(Long id, LentesDTO dto) {
        Lente lentesBanco =  lentesRepository.findById(id);

        lentesBanco.setCompatibilidade(dto.compatibilidade());
        lentesBanco.setDistanciaFocal(dto.distanciaFocal());
        lentesBanco.setDiametroFiltro(dto.diametroFiltro());
        lentesBanco.setMontagem(dto.montagem());
        lentesBanco.setPreco(dto.preco());
        lentesBanco.setMaterial(dto.material());
        lentesBanco.setDimensoes(dto.dimensoes());
        lentesBanco.setNomeModelo(dto.nomeModelo());

    }

    public void validarModelo(String modelo) {
        Lente lente = lentesRepository.validarModelo(modelo);
        if (lente != null)
            throw  new ValidationException("nomeModelo", "O modelo '"+ modelo +"' já existe.");
    }

    @Override
    @Transactional
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
    public List<LentesResponseDTO> findByMontagem(String montagem) {
        return lentesRepository
        .findByMontagem(montagem)
        .stream()
        .map(e -> LentesResponseDTO.valueOf(e)).toList();
    }
   
}
