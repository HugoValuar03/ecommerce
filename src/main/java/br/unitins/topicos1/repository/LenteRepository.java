package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Lente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LenteRepository implements PanacheRepository<Lente>{

    public List<Lente> findByMontagem(String montagem){
        return find("UPPER(montagem) LIKE ?1", "%" + montagem.toUpperCase() + "%").list();
    }
}
