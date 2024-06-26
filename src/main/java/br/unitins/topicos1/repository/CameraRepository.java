package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Camera;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CameraRepository implements PanacheRepository<Camera> {
    
    public List<Camera> findByNomeProduto(String nomeProduto){
        return find("UPPER(nomeProduto) LIKE ?1", "%" + nomeProduto.toUpperCase() + "%").list();
    }

    public Camera validarModelo(String modelo){
        return find("UPPER(nomeModelo) LIKE ?1", modelo.toUpperCase()).firstResult();
    }

    public List<Camera> findByMarca(String marca){
        return find("UPPER(marca.marca) LIKE ?1", "%" + marca.toUpperCase() + "%" ).list();
    }
    
}
