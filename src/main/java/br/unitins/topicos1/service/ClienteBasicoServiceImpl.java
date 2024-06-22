package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteBasicoDTO;
import br.unitins.topicos1.dto.ClienteBasicoResponseDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ClienteBasicoServiceImpl implements ClienteBasicoService{

    @Inject
    public PessoaRepository pessoaRepository;

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    HashService hashService;

    @Override
    @Transactional
    public ClienteBasicoResponseDTO create(@Valid ClienteBasicoDTO clienteBasico) {
        Pessoa pessoa = new Pessoa();
        
        pessoa.setNome(clienteBasico.nome());
        pessoa.setCpf(clienteBasico.cpf());
        pessoa.setSexo(Sexo.valueOf(clienteBasico.idSexo()));
        pessoa.setUsername(clienteBasico.username());
        pessoa.setSenha(hashService.getHashSenha(clienteBasico.senha()));

        pessoaRepository.persist(pessoa);

        Cliente cliente = new Cliente();

        cliente.setPessoa(pessoa);
        clienteRepository.persist(cliente);

        return ClienteBasicoResponseDTO.valueOf(cliente);

    }   

    @Override
    @Transactional
    public List<ClienteBasicoResponseDTO> findAll() {
        return clienteRepository.listAll().stream().map(a -> ClienteBasicoResponseDTO.valueOf(a)).toList();
    }
    
}
