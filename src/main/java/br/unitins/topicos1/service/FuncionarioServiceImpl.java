package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.repository.FuncionarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public  FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional 
    public FuncionarioResponseDTO create (FuncionarioDTO dto){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.nome());
        //Colocar todos os métodos correspondentes

        funcionarioRepository.persist(funcionario);
        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    @Override
    @Transactional 
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario estadoBanco = funcionarioRepository.findById(id);

        estadoBanco.setNome(dto.nome());
        //Colocar todos os métodos correspondentes
    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public List<FuncionarioResponseDTO> findAll() { //Declara uma lista de objetos do tipo `funcionario`
        return funcionarioRepository
        .listAll()
        .stream()
        .map(e -> FuncionarioResponseDTO.valueOf(e)).toList(); //Lista todo os elementos da tabela funcionario
    }

    @Override
    public List<FuncionarioResponseDTO> findByCargo(@PathParam("cargo") String cargo){
        return funcionarioRepository.findByCargo(cargo)
        .stream()
        .map(e -> FuncionarioResponseDTO.valueOf(e))
        .toList();
    }

    @Override
    public List<FuncionarioResponseDTO> findBySigla(String sigla) {
        return funcionarioRepository.listAll()
        .stream()
        .map(e -> FuncionarioResponseDTO.valueOf(e))
        .toList();
    }

    @Override
    public FuncionarioResponseDTO findById(Long id){
        return FuncionarioResponseDTO.valueOf(funcionarioRepository.findById(id)); 
    }

    @Override
    public List<FuncionarioResponseDTO> findByNome(String nome) {
        return funcionarioRepository.findByNome(nome).stream()
        .map(e -> FuncionarioResponseDTO.valueOf(e)).toList();
    }
}
