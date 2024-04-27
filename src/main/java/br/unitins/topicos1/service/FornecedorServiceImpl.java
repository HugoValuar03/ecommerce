package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.FornecedorResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.FornecedorRepository;
import br.unitins.topicos1.validation.ValidationException;
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
        validarNome(dto.nome());
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome(dto.nome());
        fornecedor.setEndereco(dto.endereco());
        fornecedor.setEmail(dto.email());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        fornecedorRepository.persist(fornecedor);
        return FornecedorResponseDTO.valueOf(fornecedor);

        
    }

    @Override
    @Transactional
    public void update(Long id, FornecedorDTO dto) {
        validarNome(dto.nome());
        
        Fornecedor fornecedorBanco =  fornecedorRepository.findById(id);

        fornecedorBanco.setNome(dto.nome());
        fornecedorBanco.setEndereco(dto.endereco());
        fornecedorBanco.setCnpj(dto.cnpj());
        fornecedorBanco.setEmail(dto.email());
        
        Telefone telefone = fornecedorBanco.getTelefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());
        
    }

    public void validarNome(String nome) {
        Fornecedor fornecedor = fornecedorRepository.validarNome(nome);
        if (fornecedor != null)
            throw  new ValidationException("nome", "O nome '"+ nome +"' já existe.");
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
        .findByCnpj(cnpj)
        .stream()
        .map(e -> FornecedorResponseDTO.valueOf(e)).toList();
    }
}
