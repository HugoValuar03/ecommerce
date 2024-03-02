package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Lentes;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LentesRepository implements PanacheRepository<Lentes>{
    
    public List<Lentes> findByNome(String nomeProduto){
        return find("UPPER(marcaProduto) LIKE ?1", "%" + nomeProduto.toUpperCase() + "%").list();
        
    }

    public List<Lentes> findByMarca(String marcaProduto){
        return find("UPPER(marcaProduto) LIKE ?1", "%" + marcaProduto.toUpperCase() + "%").list();
    }
}
