package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService {

    @Inject
    public  PessoaRepository pessoaRepository;

    @Override
    @Transactional 
    public PessoaResponseDTO create (PessoaDTO dto){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        //Colocar todos os métodos correspondentes

        pessoaRepository.persist(pessoa);
        return PessoaResponseDTO.valueOf(pessoa);
    }

    @Override
    @Transactional 
    public void update(Long id, PessoaDTO dto) {
        Pessoa estadoBanco = pessoaRepository.findById(id);

        estadoBanco.setNome(dto.nome());
        //Colocar todos os métodos correspondentes
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public List<PessoaResponseDTO> findAll() { //Declara uma lista de objetos do tipo `Pessoa`
        return pessoaRepository
        .listAll()
        .stream()
        .map(e -> PessoaResponseDTO.valueOf(e)).toList(); //Lista todo os elementos da tabela Pessoa
    }

    @Override
    public List<PessoaResponseDTO> findByCargo(@PathParam("cargo") String cargo){
        return pessoaRepository.findByCargo(cargo)
        .stream()
        .map(e -> PessoaResponseDTO.valueOf(e))
        .toList();
    }

    @Override
    public List<PessoaResponseDTO> findBySigla(String sigla) {
        return pessoaRepository.listAll()
        .stream()
        .map(e -> PessoaResponseDTO.valueOf(e))
        .toList();
    }

    @Override
    public PessoaResponseDTO findById(Long id){
        return PessoaResponseDTO.valueOf(pessoaRepository.findById(id)); 
    }

    @Override
    public List<PessoaResponseDTO> findByNome(String nome) {
        return pessoaRepository.findByNome(nome).stream()
        .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }
}
