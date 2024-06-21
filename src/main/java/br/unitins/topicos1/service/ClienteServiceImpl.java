package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UpdateEmailDTO;
import br.unitins.topicos1.dto.UpdateNomeDTO;
import br.unitins.topicos1.dto.UpdateSenhaDTO;
import br.unitins.topicos1.dto.UpdateUsernameDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.FuncionarioRepository;
import br.unitins.topicos1.repository.PessoaRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {
    
    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public HashService hash;

    @Inject
    public PessoaRepository pessoaRepository;
        
    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto){
        validarCpf(dto.cpf());
        
        Cliente cliente = new Cliente();
        Pessoa pessoa = new Pessoa();
        
        pessoa.setNome(dto.nome());
        pessoa.setSexo(Sexo.valueOf(dto.idSexo()));
        pessoa.setAniversario(dto.aniversario());
        pessoa.setCpf(dto.cpf());
        pessoa.setEmail(dto.email());
        pessoa.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        pessoaRepository.persist(pessoa);

        cliente.setPessoa(pessoa);

        clienteRepository.persist(cliente);
        return new ClienteResponseDTO(cliente);

    }
    
    public void validarCpf(String cpf) {
        Pessoa cliente = pessoaRepository.validarCpf(cpf);
        if (cliente != null)
            throw  new ValidationException("pessoa.cpf", "O cpf '"+ cpf +"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {

        Cliente clienteBanco = clienteRepository.findById(id);

        clienteBanco.getPessoa().setNome(dto.nome());
        clienteBanco.getPessoa().setAniversario(dto.aniversario());
        clienteBanco.getPessoa().setEmail(dto.email());
        clienteBanco.getPessoa().setCpf(dto.cpf());
        clienteBanco.getPessoa().setAniversario(dto.aniversario());
        clienteBanco.getPessoa().setSexo(Sexo.valueOf(dto.idSexo()));
        clienteBanco.getPessoa().setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));
            
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return new ClienteResponseDTO(clienteRepository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        return clienteRepository
        .listAll()
        .stream()
        .map(e -> new ClienteResponseDTO(e)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByCpf(String cpf) {
        return clienteRepository
        .findByCpf(cpf)
        .stream()
        .map(e -> new ClienteResponseDTO(e)).toList();
    }

    @Override
    public PessoaResponseDTO login(String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
        return new PessoaResponseDTO(cliente.getPessoa());
    }

    @Override
    public ClienteResponseDTO updateEmail(Long id, UpdateEmailDTO email) {

        Cliente cliente = clienteRepository.findById(id);
        cliente.getPessoa().setEmail(email.email());
        return new ClienteResponseDTO(cliente);

    }

    @Override
    public ClienteResponseDTO updateNome(Long id, UpdateNomeDTO nome) {

        Cliente cliente = clienteRepository.findById(id);
        cliente.getPessoa().setNome(nome.nome());
        clienteRepository.persist(cliente);
        return new ClienteResponseDTO(cliente);
        
    }

    @Override
    public ClienteResponseDTO updateUsername(Long id, UpdateUsernameDTO username) {

        Cliente cliente = clienteRepository.findById(id);
        cliente.getPessoa().setUsername(username.username());
        clienteRepository.persist(cliente);
        return new ClienteResponseDTO(cliente);

    }

    @Override
    public ClienteResponseDTO updateSenha(Long id, UpdateSenhaDTO senha) {
        Cliente cliente = clienteRepository.findById(id);
        
        cliente.getPessoa().setSenha(hash.getHashSenha(senha.novaSenha()));

        hash.getHashSenha(senha.novaSenha());

        return new ClienteResponseDTO(cliente);
    }

    
    
}
