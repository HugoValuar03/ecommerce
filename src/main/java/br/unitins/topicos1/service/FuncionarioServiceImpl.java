package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.model.Telefone;
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
        Pessoa pessoa = new Pessoa();
        
        pessoa.setNome(dto.pessoa().nome());
        pessoa.setEmail(dto.pessoa().email());
        pessoa.setCpf(dto.pessoa().email());
        pessoa.setAniversario(dto.pessoa().aniversario());
        pessoa.setSexo(Sexo.valueOf(dto.pessoa().idSexo()));
        
        Telefone telefone = funcionario.getPessoa().getTelefone();
        telefone.setCodigoArea(dto.pessoa().telefone().codigoArea());
        telefone.setNumero(dto.pessoa().telefone().numero());

        funcionario.setPessoa(pessoa);
        funcionario.setCargo(dto.cargo());

        funcionarioRepository.persist(funcionario);
        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    @Override
    @Transactional 
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionarioBanco = funcionarioRepository.findById(id);
        Pessoa pessoaBanco = funcionarioBanco.getPessoa();
        pessoaBanco.setNome(dto.pessoa().nome());
        pessoaBanco.setAniversario(dto.pessoa().aniversario());
        pessoaBanco.setCpf(dto.pessoa().cpf());
        pessoaBanco.setEmail(dto.pessoa().email());
        pessoaBanco.setSexo(Sexo.valueOf(dto.pessoa().idSexo()));
        
        Telefone telefone = funcionarioBanco.getPessoa().getTelefone();
        telefone.setCodigoArea(dto.pessoa().telefone().codigoArea());
        telefone.setNumero(dto.pessoa().telefone().numero());

        funcionarioBanco.setCargo(dto.cargo());

        funcionarioBanco.setPessoa(pessoaBanco);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public List<FuncionarioResponseDTO> findAll() { //Declara uma lista de objetos do tipo funcionario
        return funcionarioRepository
        .listAll()
        .stream()
        .map(e -> FuncionarioResponseDTO.valueOf(e))
        .toList(); //Lista todo os elementos da tabela funcionario
    }

    @Override
    public List<FuncionarioResponseDTO> findByCargo(@PathParam("cargo") String cargo){
        return funcionarioRepository.findByCargo(cargo)
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
        return funcionarioRepository.findByNome(nome)
        .stream()
        .map(e -> FuncionarioResponseDTO.valueOf(e))
        .toList();
    }
}
