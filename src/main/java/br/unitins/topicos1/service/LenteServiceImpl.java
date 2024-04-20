package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.dto.LentesResponseDTO;
import br.unitins.topicos1.model.Lente;
import br.unitins.topicos1.repository.LenteRepository;
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
           Lente lentes = new Lente();
           
           lentes.setCompatibilidade(dto.compatibilidade());
           lentes.setDistanciaFocal(dto.distandicaFocal());
           lentes.setDiametroFiltro(dto.diametroFiltro());
           lentes.setMontagem(dto.montagem());
           lentes.setNomeProduto(dto.nomeProduto());
           lentes.setPreco(dto.preco());
           lentes.setMaterial(dto.material());
           lentes.setDimensoes(dto.dimensoes());
           lentes.setNomeModelo(dto.nomeModelo());   
           lentes.getCadastro().setResponsavel(dto.responsavel());
           lentes.getCadastro().setCategoria(dto.categoria());
           lentes.getCadastro().setStatus(dto.status());
           lentes.getCadastro().setDataCadastro(dto.dataCadastro());
           lentes.getCadastro().setDataAlteracao(dto.dataAlteracao());        

           lentesRepository.persist(lentes);
           return LentesResponseDTO.valueOf(lentes);    
    }

    @Override
    @Transactional
    public void update(Long id, LentesDTO dto) {
        Lente lentesBanco =  lentesRepository.findById(id);

        lentesBanco.setCompatibilidade(dto.compatibilidade());
        lentesBanco.setDistanciaFocal(dto.distandicaFocal());
        lentesBanco.setDiametroFiltro(dto.diametroFiltro());
        lentesBanco.setMontagem(dto.montagem());
        lentesBanco.setNomeProduto(dto.nomeProduto());
        lentesBanco.setPreco(dto.preco());
        lentesBanco.setMaterial(dto.material());
        lentesBanco.setDimensoes(dto.dimensoes());
        lentesBanco.setNomeModelo(dto.nomeModelo());
        lentesBanco.getCadastro().setResponsavel(dto.responsavel());
        lentesBanco.getCadastro().setStatus(dto.status());
        lentesBanco.getCadastro().setCategoria(dto.categoria());
        lentesBanco.getCadastro().setDataAlteracao(dto.dataAlteracao());
        lentesBanco.getCadastro().setDataCadastro(dto.dataCadastro());

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
    public List<LentesResponseDTO> findByMarca(String marca) {
        return lentesRepository
        .findByMarca(marca)
        .stream()
        .map(e -> LentesResponseDTO.valueOf(e)).toList();
    }
    
}