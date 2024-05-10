package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca>{

    public List<Marca> findByNome(String marca){
        return find("UPPER(marca) LIKE ?1", "%" + marca.toUpperCase() + "%").list();
    }
    
    public Marca validarMarca(String marca){
        return find("UPPER(marca) LIKE ?1", marca.toUpperCase()).firstResult();
    }

}
