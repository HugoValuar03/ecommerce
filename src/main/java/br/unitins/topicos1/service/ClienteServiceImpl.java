package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {
    
    @Inject
    public ClienteRepository clienteRepository;
        
    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto){
        Cliente cliente = new Cliente();
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(dto.pessoa().nome());
        pessoa.setSexo(Sexo.valueOf(dto.pessoa().idSexo()));
        pessoa.setAniversario(dto.pessoa().aniversario());
        pessoa.setCpf(dto.pessoa().cpf());
        pessoa.setEmail(dto.pessoa().email());

        cliente.setPessoa(pessoa);

        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.pessoa().telefone().codigoArea());
        telefone.setNumero(dto.pessoa().telefone().numero());

        pessoa.setTelefone(telefone);

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);

    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {

        Cliente clienteBanco = clienteRepository.findById(id);
        Pessoa pessoaBanco = clienteBanco.getPessoa();

        pessoaBanco.setNome(dto.pessoa().nome());
        pessoaBanco.setAniversario(dto.pessoa().aniversario());
        pessoaBanco.setEmail(dto.pessoa().email());
        pessoaBanco.setCpf(dto.pessoa().cpf());
        pessoaBanco.setAniversario(dto.pessoa().aniversario());
        pessoaBanco.setSexo(Sexo.valueOf(dto.pessoa().idSexo()));
        
        Telefone telefone = clienteBanco.getPessoa().getTelefone();
        telefone.setCodigoArea(dto.pessoa().telefone().codigoArea());
        telefone.setNumero(dto.pessoa().telefone().numero());
        
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
        return clienteRepository.findByCpf(cpf).stream()
        .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }
}
