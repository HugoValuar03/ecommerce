package br.unitins.topicos1.service;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.PessoaDTO;
import br.unitins.topicos1.dto.PessoaResponseDTO;
import br.unitins.topicos1.dto.PessoaUpdateEmailDTO;
import br.unitins.topicos1.dto.PessoaUpdateNomeDTO;
import br.unitins.topicos1.dto.PessoaUpdateSenhaDTO;
import br.unitins.topicos1.dto.PessoaUpdateUsernameDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.PessoaRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService{

    public static final Logger LOG = Logger.getLogger(PessoaServiceImpl.class);

    @Inject
    private PessoaRepository pessoaRepository;

    @Inject
    private HashService hash;

    @Override
    @Transactional
    public PessoaResponseDTO create(@Valid PessoaDTO dto) {

        try {
            LOG.info("Realizando Pessoa.create()");

            validarCpf(dto.cpf());

            Pessoa pessoa = new Pessoa();

            pessoa.setNome(dto.nome());
            pessoa.setAniversario(dto.aniversario());
            pessoa.setCpf(dto.cpf());
            pessoa.setEmail(dto.email());
            pessoa.setSexo(Sexo.valueOf(dto.idSexo()));
            pessoa.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

            pessoaRepository.persist(pessoa);
            return new PessoaResponseDTO(pessoa);

        } catch (Exception e) {
            LOG.error("Erro ao rodar requisição Pessoa.create()");
            return null;
        }

    }

    public void validarCpf(String cpf) {
        Pessoa pessoa = pessoaRepository.validarCpf(cpf);
        if (pessoa != null)
            throw  new ValidationException("cpf", "O cpf "+ cpf +" já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, PessoaDTO dto) {

        LOG.info("Realizando Pessoa.update()");

        Pessoa pessoaBanco = pessoaRepository.findById(id);

        pessoaBanco.setNome(dto.nome());
        pessoaBanco.setCpf(dto.cpf());
        pessoaBanco.setEmail(dto.email());
        pessoaBanco.setAniversario(dto.aniversario());
        pessoaBanco.setSexo(Sexo.valueOf(dto.idSexo()));
        
        Telefone telefone = pessoaBanco.getTelefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());
            
    }

    @Override
    @Transactional
    public void delete(Long id) {
        LOG.info("Realizando Pessoa.delete()");
        pessoaRepository.deleteById(id);
    }

    @Override
    public PessoaResponseDTO findById(Long id) {
        return new PessoaResponseDTO(pessoaRepository.findById(id));
    }

    @Override
    public List<PessoaResponseDTO> findBynome(String nome) {
        return pessoaRepository
        .findByNome(nome)
        .stream()
        .map(e -> new PessoaResponseDTO(e)).toList();
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        return pessoaRepository
        .listAll()
        .stream()
        .map(e -> new PessoaResponseDTO(e))
        .toList();
    }

    @Override
    public PessoaResponseDTO updateEmail(Long id, PessoaUpdateEmailDTO email) {
        try {
            LOG.info("Requisição Pessoa.updateEmail()");

            Pessoa pessoa = pessoaRepository.findById(id);
            if(hash.getHashSenha(email.senha()) != hash.getHashSenha(pessoa.getSenha()))
                throw new NotFoundException("Senha Incorreta!");

            pessoa.setEmail(email.email());
            LOG.info("Email alterado com sucesso!");
            return new PessoaResponseDTO(pessoa);
        } catch (Exception e) {
            LOG.error("Erro ao rodar requisição Pessoa.updateEmail()");
            return null;
        }
    }

    @Override
    public PessoaResponseDTO updateNome(Long id, PessoaUpdateNomeDTO nome) {
        try {
            LOG.info("Realizando requisição Pessoa.updateNome()");
            Pessoa pessoa = pessoaRepository.findById(id);
            if(hash.getHashSenha(nome.senha()) != pessoa.getSenha())
                throw new NotFoundException("Senha incorreta!");
            try {
                pessoa.setNome(nome.nome());
                LOG.info("Nome alterado com sucesso");
            } catch (Exception e) {
                LOG.error("Nome não foi alterado");
            }
            pessoaRepository.persist(pessoa);
            return new PessoaResponseDTO(pessoa);
        } catch (Exception e) {
            LOG.error("Erro ao rodar requisição Pessoa.updateNome()");
            return null;
        }

    }

    @Override
    public PessoaResponseDTO updateUsername(Long id, PessoaUpdateUsernameDTO username) {
        
        try {
            LOG.info("Requisição updateLogin()");

            Pessoa pessoa = pessoaRepository.findById(id);

            if(hash.getHashSenha(username.senha()) != pessoa.getSenha())
                throw new NotFoundException("Senha incorreta!");

            try {
                pessoa.setUsername(username.username());
                LOG.info("Username alterado com sucesso!");
            } catch (Exception e) {
                LOG.error("Erro ao alterar username");
            }

            pessoaRepository.persist(pessoa);

            return new PessoaResponseDTO(pessoa);

        } catch (Exception e) {
            LOG.error("Erro ao rodar requisição Pessoa.updateUsername()");
            return null;
        }
    }

    @Override
    public PessoaResponseDTO updateSenha(Long id, PessoaUpdateSenhaDTO senha) {
        
        try {
            LOG.info("Requisição updateSenha()");

            Pessoa pessoa = pessoaRepository.findById(id);
            
            if(hash.getHashSenha(senha.senhaAntiga()) != pessoa.getSenha())
                throw new NotFoundException("Senha antiga incorreta");

            try {
                pessoa.setSenha(hash.getHashSenha(senha.novaSenha()));
                LOG.info("Senha alterada com sucesso!");
            } catch (Exception e) {
                LOG.error("Senha não alterada");
            }

            return new PessoaResponseDTO(pessoa);
        } catch (Exception e) {
            LOG.info("Erro ao rodar requisição Pessoa.updateSenha()");
            return null;
        }
    }
}