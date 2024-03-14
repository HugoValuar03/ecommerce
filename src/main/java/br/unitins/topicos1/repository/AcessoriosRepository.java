package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Acessorios;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AcessoriosRepository implements PanacheRepository<Acessorios>{
    
    public List<Acessorios> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }
}
