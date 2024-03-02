package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Cameras;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CamerasRepository implements PanacheRepository<Cameras> {
    
    public List<Cameras> findByNomeProduto(String nomeProduto){
        return find("UPPER(nomeProduto) LIKE ?1", "%" + nomeProduto.toUpperCase() + "%").list();
    }

    public List<Cameras> findByMarca(String marca){
        return find("UPPER(marca) LIKE ?1", "%" + marca.toUpperCase() + "%").list();
    }
}
