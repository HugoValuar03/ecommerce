package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.repository.FuncionarioRepository;
import br.unitins.topicos1.repository.PessoaRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public  FuncionarioRepository funcionarioRepository;

    @Inject
    public PessoaRepository pessoaRepository;

    @Override
    @Transactional 
    public FuncionarioResponseDTO create (FuncionarioDTO dto){
        validarCpf(dto.cpf());
        
        Funcionario funcionario = new Funcionario();
        Pessoa pessoa = new Pessoa();
        
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setCpf(dto.email());
        pessoa.setAniversario(dto.aniversario());
        pessoa.setSexo(Sexo.valueOf(dto.idSexo()));
        pessoa.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));
        
        pessoaRepository.persist(pessoa);
        
        funcionario.setPessoa(pessoa);
        funcionario.setCargo(dto.cargo());

        funcionarioRepository.persist(funcionario);
        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    public void validarCpf(String cpf) {
        Pessoa funcionario = pessoaRepository.validarCpf(cpf);
        if (funcionario != null)
            throw  new ValidationException("pessoa.cpf", "O cpf "+ cpf +" já existe.");
    }

    @Override
    @Transactional 
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionarioBanco = funcionarioRepository.findById(id);
        Pessoa pessoaBanco = funcionarioBanco.getPessoa();

        pessoaBanco.setNome(dto.nome());
        pessoaBanco.setAniversario(dto.aniversario());
        pessoaBanco.setCpf(dto.cpf());
        pessoaBanco.setEmail(dto.email());
        pessoaBanco.setSexo(Sexo.valueOf(dto.idSexo()));
        
        pessoaBanco.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

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
    public PessoaResponseDTO login(String username, String senha) {
        
        Funcionario funcionario = funcionarioRepository.findByUsernameAndSenha(username, senha);
        return PessoaResponseDTO.valueOf(funcionario.getPessoa());
        
    }
}
