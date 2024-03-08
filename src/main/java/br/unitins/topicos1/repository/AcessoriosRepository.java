package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Acessorios;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AcessoriosRepository implements PanacheRepository<Acessorios>{
    
    public List<Acessorios> findByNomeAcessorios(String nomeAcessorios){
        return find("UPPER(nomeAcessorios) LIKE ?1", "%" + nomeAcessorios.toUpperCase() + "%").list();
    }
}
