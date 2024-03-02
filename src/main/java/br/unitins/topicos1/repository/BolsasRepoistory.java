package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Bolsas;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BolsasRepoistory implements PanacheRepository<Bolsas>{
    
    public List<Bolsas> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Bolsas> findByMarca(String marca){
        return find("UPPER(marca) LIKE ?1", "%" + marca.toUpperCase() + "%").list();
    }
}
