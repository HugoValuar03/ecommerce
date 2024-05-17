package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.FuncionarioRepository;
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
    public HashService hashService;
        
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

        cliente.setPessoa(pessoa);

        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());

        pessoa.setTelefone(telefone);

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);

    }
    
    public void validarCpf(String cpf) {
        Cliente cliente = clienteRepository.validarCpf(cpf);
        if (cliente != null)
            throw  new ValidationException("pessoa.cpf", "O cpf '"+ cpf +"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {

        Cliente clienteBanco = clienteRepository.findById(id);
        Pessoa pessoaBanco = clienteBanco.getPessoa();

        pessoaBanco.setNome(dto.nome());
        pessoaBanco.setAniversario(dto.aniversario());
        pessoaBanco.setEmail(dto.email());
        pessoaBanco.setCpf(dto.cpf());
        pessoaBanco.setAniversario(dto.aniversario());
        pessoaBanco.setSexo(Sexo.valueOf(dto.idSexo()));
        
        Telefone telefone = clienteBanco.getPessoa().getTelefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());
        
        clienteBanco.setPessoa(pessoaBanco);
            
    }

    

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(clienteRepository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        return clienteRepository
        .listAll()
        .stream()
        .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByCpf(String cpf) {
        return clienteRepository
        .findByCpf(cpf)
        .stream()
        .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(cliente.getPessoa());
    }
}
