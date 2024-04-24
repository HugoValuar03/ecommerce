package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa>{
    
    public List<Pessoa> findByNome(String nomePessoa){
        return find("UPPER(marcaPessoa) LIKE ?1", "%" + nomePessoa.toUpperCase() + "%").list();
    }

    public List<Pessoa> findByCpf(String cpfPessoa){
        return find("UPPER(cpfPessoa) LIKE ?1", "%" + cpfPessoa.toUpperCase() + "%").list();
    }
}
