package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Lentes;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LentesRepository implements PanacheRepository<Lentes>{
    
    @Transactional

    public List<Lentes> findByNome(String nomeProduto){
        return find("UPPER(nomeProduto) LIKE ?1", "%" + nomeProduto.toUpperCase() + "%").list();
        
    }

    public List<Lentes> findByMarca(String marcaProduto){
        return find("UPPER(marcaProduto) LIKE ?1", "%" + marcaProduto.toUpperCase() + "%").list();
    }
}
