package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.FornecedorResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.FornecedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService {

    @Inject
    private FornecedorRepository fornecedorRepository;

    @Override
    @Transactional
    public FornecedorResponseDTO create(@Valid FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome(dto.nome());
        fornecedor.setEndereco(dto.endereco());
        fornecedor.setEmail(dto.email());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setListaTelefone(new ArrayList<Telefone>());

        for (TelefoneDTO tel : dto.listaTelefone()) {
            Telefone t = new Telefone();
            t.setCodigoArea(tel.codigoArea());
            t.setNumero(tel.numero());
            fornecedor.getListaTelefone().add(t);
        }

        fornecedorRepository.persist(fornecedor);
        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @Override
    @Transactional
    public void update(Long id, FornecedorDTO dto) {
        Fornecedor fornecedorBanco =  fornecedorRepository.findById(id);

        fornecedorBanco.setNome(dto.nome());
        fornecedorBanco.setEndereco(dto.endereco());
        fornecedorBanco.setCnpj(dto.cnpj());
        fornecedorBanco.setEmail(dto.email());

        fornecedorBanco.getListaTelefone().clear();
        
        for (TelefoneDTO tel : dto.listaTelefone()) {
            Telefone t = new Telefone();
            t.setCodigoArea(tel.codigoArea());
            t.setNumero(tel.numero());
            fornecedorBanco.getListaTelefone().add(t);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }

    @Override
    public FornecedorResponseDTO findById(Long id) {
        return FornecedorResponseDTO.valueOf(fornecedorRepository.findById(id)); 
    }

    @Override
    public List<FornecedorResponseDTO> findAll() {
        return fornecedorRepository
        .listAll()
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<FornecedorResponseDTO> findByNome(String nome) {
        return fornecedorRepository
        .findByNome(nome)
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<FornecedorResponseDTO> findByCnpj(String cnpj) {
        return fornecedorRepository
        .findByNome(cnpj)
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }
}
