package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.AcessoriosDTO;
import br.unitins.topicos1.dto.AcessoriosResponseDTO;
import br.unitins.topicos1.model.Acessorios;
import br.unitins.topicos1.repository.AcessoriosRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

public class AcessoriosServiceImpl implements AcessoriosService{

    @Inject
    private AcessoriosRepository acessoriosRepository;

    @Override
    public AcessoriosResponseDTO create(@Valid AcessoriosDTO dto) {
        
        Acessorios acessorios = new Acessorios();

        acessorios.setAcessorio(dto.acessorio());
        acessorios.setAltura(dto.altura());
        acessorios.setCompatibilidade(dto.compatibilidade());
        acessorios.setCor(dto.cor());
        acessorios.setLargura(dto.largura());
        acessorios.setMaterial(dto.material());
        acessorios.setNomeProduto(dto.nomeProduto());
        acessorios.setPeso(dto.peso());
        acessorios.setPreco(dto.preco());

        acessoriosRepository.persist(acessorios);

        return AcessoriosResponseDTO.valueOf(acessorios);
    }

    @Override
    public void update(Long id, AcessoriosDTO dto) {

        Acessorios estadoBanco =  acessoriosRepository.findById(id);

        estadoBanco.setAcessorio(dto.acessorio());
        estadoBanco.setAltura(dto.altura());
        estadoBanco.setCompatibilidade(dto.compatibilidade());
        estadoBanco.setCor(dto.cor());
        estadoBanco.setLargura(dto.largura());
        estadoBanco.setMaterial(dto.material());
        estadoBanco.setNomeProduto(dto.nomeProduto());
        estadoBanco.setPeso(dto.peso());
        estadoBanco.setPreco(dto.preco());
    }

    @Override
    public void delete(Long id) {
        acessoriosRepository.deleteById(id);
    }

    @Override
    public AcessoriosResponseDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<AcessoriosResponseDTO> findAll() {
        return acessoriosRepository
        .listAll()
        .stream()
        .map(a -> AcessoriosResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<AcessoriosResponseDTO> findByNome(String nome) {
        return acessoriosRepository
        .findByNome(nome)
        .stream()
        .map(a -> AcessoriosResponseDTO.valueOf(a)).toList();
    }
    
}
