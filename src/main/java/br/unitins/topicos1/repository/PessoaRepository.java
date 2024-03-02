package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa>{

    @Transactional
    public Pessoa save(Pessoa pessoa) {
        persist(pessoa);
        return pessoa;
    }

    
    public List<Pessoa> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase()  + "%").list();
    }

    public List<Pessoa> findByCargo(String cargo){
        return find("UPPER(cargo) LIKE ?1","%" + cargo.toUpperCase() + "%").list();
    }
}
