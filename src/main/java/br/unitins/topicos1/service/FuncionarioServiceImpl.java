package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UpdateEmailDTO;
import br.unitins.topicos1.dto.UpdateNomeDTO;
import br.unitins.topicos1.dto.UpdateSenhaDTO;
import br.unitins.topicos1.dto.UpdateUsernameDTO;
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

    @Inject
    public HashService hash;

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
        return new FuncionarioResponseDTO(funcionario);
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
    public List<FuncionarioResponseDTO> findAll() { 
        return funcionarioRepository
        .listAll()
        .stream()
        .map(e -> new FuncionarioResponseDTO(e))
        .toList(); 
    }

    @Override
    public List<FuncionarioResponseDTO> findByCargo(@PathParam("cargo") String cargo){
        return funcionarioRepository.findByCargo(cargo)
        .stream()
        .map(e -> new FuncionarioResponseDTO(e))
        .toList();
    }

    @Override
    public FuncionarioResponseDTO findById(Long id){
        return new FuncionarioResponseDTO(funcionarioRepository.findById(id)); 
    }

    @Override
    public PessoaResponseDTO login(String username, String senha) {
        
        Funcionario funcionario = funcionarioRepository.findByUsernameAndSenha(username, senha);
        return new PessoaResponseDTO(funcionario.getPessoa());
        
    }

    @Override
    public FuncionarioResponseDTO updateEmail(Long id, UpdateEmailDTO email) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        funcionario.getPessoa().setEmail(email.email());
        return new FuncionarioResponseDTO(funcionario);
    }

    @Override
    public FuncionarioResponseDTO updateNome(Long id, UpdateNomeDTO nome) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        funcionario.getPessoa().setNome(nome.nome());
        funcionarioRepository.persist(funcionario);
        return new FuncionarioResponseDTO(funcionario);
    }

    @Override
    public FuncionarioResponseDTO updateUsername(Long id, UpdateUsernameDTO username) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        funcionario.getPessoa().setUsername(username.username());
        funcionarioRepository.persist(funcionario);
        return new FuncionarioResponseDTO(funcionario);
    }

    @Override
    public FuncionarioResponseDTO updateSenha(Long id, UpdateSenhaDTO senha) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        funcionario.getPessoa().setSenha(hash.getHashSenha(senha.novaSenha()));
        hash.getHashSenha(senha.novaSenha());
        return new FuncionarioResponseDTO(funcionario);
    }
}
