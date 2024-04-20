package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Cliente;
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
        cliente.getPessoa().setNome(dto.nome());
        cliente.getPessoa().setEmail(dto.email());
        cliente.getPessoa().setCpf(dto.cpf());
        cliente.getPessoa().setAniversario(dto.aniversario());
        cliente.getPessoa().setSexo(Sexo.valueOf(dto.idSexo()));
        cliente.getPessoa().setListaTelefone(new ArrayList<Telefone>());

        for (TelefoneDTO tel : dto.telefones()) {
            Telefone t = new Telefone();
            t.setCodigoArea(tel.codigoArea());
            t.setNumero(tel.numero());
            cliente.getPessoa().getListaTelefone().add(t);
        }

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);

    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {
        Cliente clienteBanco = clienteRepository.findById(id);
            clienteBanco.getPessoa().setNome(dto.nome());
            clienteBanco.getPessoa().setEmail(dto.email());
            clienteBanco.getPessoa().setCpf(dto.cpf());
            clienteBanco.getPessoa().setAniversario(dto.aniversario());
            clienteBanco.getPessoa().setSexo(Sexo.valueOf(dto.idSexo()));
            clienteBanco.getPessoa().setListaTelefone(new ArrayList<Telefone>());

            clienteBanco.getPessoa().getListaTelefone().clear();
            
            for (TelefoneDTO tel : dto.telefones()) {
                Telefone t = new Telefone();
                t.setCodigoArea(tel.codigoArea());
                t.setNumero(tel.numero());
                clienteBanco.getPessoa().getListaTelefone().add(t); 
        }
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
