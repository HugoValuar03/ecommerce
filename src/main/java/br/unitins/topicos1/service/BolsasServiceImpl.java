package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.BolsasDTO;
import br.unitins.topicos1.dto.BolsasResponseDTO;
import br.unitins.topicos1.model.Bolsas;
import br.unitins.topicos1.repository.BolsasRepoistory;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

public class BolsasServiceImpl implements BolsasService{

    @Inject
    private BolsasRepoistory bolsasRepository;

    @Override
    public BolsasResponseDTO create(@Valid BolsasDTO dto) {
        Bolsas bolsas = new Bolsas();

        bolsas.setAltura(dto.altura());
        bolsas.setCor(dto.cor());
        bolsas.setLargura(dto.largura());
        bolsas.setMarca(dto.marca());
        bolsas.setModelo(dto.modelo());
        bolsas.setNomeProduto(dto.nome());
        bolsas.setPreco(dto.valor());

        bolsasRepository.persist(bolsas);

        return BolsasResponseDTO.valueof(bolsas);
    }

    @Override
    public void update(Long id, BolsasDTO dto) {

        Bolsas estadoBanco =  bolsasRepository.findById(id);

        estadoBanco.setAltura(dto.altura());
        estadoBanco.setCor(dto.cor());
        estadoBanco.setLargura(dto.largura());
        estadoBanco.setMarca(dto.marca());
        estadoBanco.setModelo(dto.modelo());
        estadoBanco.setNomeProduto(dto.nome());
        estadoBanco.setPreco(dto.valor());

    }

    @Override
    public void delete(Long id) {
        bolsasRepository.deleteById(id);
    }

    @Override
    public BolsasResponseDTO findById(Long id) {
        return BolsasResponseDTO.valueof(bolsasRepository.findById(id));
    }

    @Override
    public List<BolsasResponseDTO> findAll() {
        return bolsasRepository
        .listAll()
        .stream()
        .map(e -> BolsasResponseDTO.valueof(e)).toList();
    }

    @Override
    public List<BolsasResponseDTO> findByMarca(String marca) {
        return bolsasRepository
        .findByMarca(marca)
        .stream()
        .map(e -> BolsasResponseDTO.valueof(e)).toList();
    }

    @Override
    public List<BolsasResponseDTO> findByNome(String nome) {
        return bolsasRepository
        .findByNome(nome)
        .stream()
        .map(e -> BolsasResponseDTO.valueof(e)).toList();
    }
    
}
