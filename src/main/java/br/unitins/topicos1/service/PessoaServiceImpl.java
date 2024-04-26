package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService{

    @Inject
    private PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public PessoaResponseDTO create(@Valid PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(dto.nome());
        pessoa.setAniversario(dto.aniversario());
        pessoa.setCpf(dto.cpf());
        pessoa.setEmail(dto.email());
        pessoa.setSexo(Sexo.valueOf(dto.idSexo()));
        pessoa.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        pessoaRepository.persist(pessoa);
        return PessoaResponseDTO.valueOf(pessoa);
    }

    @Override
    @Transactional
    public void update(Long id, PessoaDTO dto) {
        Pessoa pessoaBanco = pessoaRepository.findById(id);

        pessoaBanco.setNome(dto.nome());
        pessoaBanco.setCpf(dto.cpf());
        pessoaBanco.setEmail(dto.email());
        pessoaBanco.setAniversario(dto.aniversario());
        pessoaBanco.setSexo(Sexo.valueOf(dto.idSexo()));
        
        Telefone telefone = pessoaBanco.getTelefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());
    }

    @Override
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public PessoaResponseDTO findById(Long id) {
        return PessoaResponseDTO.valueOf(pessoaRepository.findById(id));
    }

    @Override
    public List<PessoaResponseDTO> findBynome(String nome) {
        return pessoaRepository
        .findByNome(nome)
        .stream()
        .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        return pessoaRepository
        .listAll()
        .stream()
        .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }
    
}