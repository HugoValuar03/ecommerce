package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.LentesDTO;
import br.unitins.topicos1.dto.LentesResponseDTO;
import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.model.Lentes;
import br.unitins.topicos1.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;

@ApplicationScoped
public class LentesServiceImpl implements LentesService {

    // @Override
    // @Transactional 
    // public PessoaResponseDTO create (PessoaDTO dto){
    //     Pessoa pessoa = new Pessoa();
    //     pessoa.setNome(dto.nome());
    //     //Colocar todos os métodos correspondentes

    //     pessoaRepository.persist(pessoa);
    //     return PessoaResponseDTO.valueOf(pessoa);
    // }

    // @Override
    // @Transactional 
    // public void update(Long id, PessoaDTO dto) {
    //     Pessoa estadoBanco = pessoaRepository.findById(id);

    //     estadoBanco.setNome(dto.nome());
    //     //Colocar todos os métodos correspondentes
    // }

    // @Override
    // @Transactional
    // public void delete(Long id) {
    //     pessoaRepository.deleteById(id);
    // }

    // @Override
    // public List<PessoaResponseDTO> findAll() { //Declara uma lista de objetos do tipo `Pessoa`
    //     return pessoaRepository
    //     .listAll()
    //     .stream()
    //     .map(e -> PessoaResponseDTO.valueOf(e)).toList(); //Lista todo os elementos da tabela Pessoa
    // }

    // @Override
    // public List<PessoaResponseDTO> findByCargo(@PathParam("cargo") String cargo){
    //     return pessoaRepository.findByCargo(cargo)
    //     .stream()
    //     .map(e -> PessoaResponseDTO.valueOf(e))
    //     .toList();
    // }

    // @Override
    // public List<PessoaResponseDTO> findBySigla(String sigla) {
    //     return pessoaRepository.listAll()
    //     .stream()
    //     .map(e -> PessoaResponseDTO.valueOf(e))
    //     .toList();
    // }

    // @Override
    // public PessoaResponseDTO findById(Long id){
    //     return PessoaResponseDTO.valueOf(pessoaRepository.findById(id)); 
    // }

    // @Override
    // public List<PessoaResponseDTO> findByNome(String nome) {
    //     return pessoaRepository.findByNome(nome).stream()
    //     .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    // }

    @Inject
    private LentesService lentesService;

    @Override
    public LentesResponseDTO create(@Valid LentesDTO dto) {

           Lentes lentes = new Lentes();
           
           lentes.setNomeProduto(dto.nomeProduto());
           lentes.setPreco(dto.preco());
           lentes.setMaterial(dto.mate);
           lentes.set
           lentes.set
           lentes.set
           lentes.set
    //     Pessoa pessoa = new Pessoa();
    //     pessoa.setNome(dto.nome());


    //     pessoaRepository.persist(pessoa);
    //     return PessoaResponseDTO.valueOf(pessoa);
    }

    @Override
    public void update(Long id, LentesDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public LentesResponseDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<PessoaResponseDTO> findByNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNome'");
    }

    @Override
    public List<PessoaResponseDTO> findByMarca(String marca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByMarca'");
    }
    
}
