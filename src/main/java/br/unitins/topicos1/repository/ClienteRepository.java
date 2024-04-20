package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente>{
    
    @Transactional
    public List<Cliente> findByCpf(String cpf){
        return find("UPPER(cpf) LIKE ?1", "%" + cpf.toUpperCase()  + "%").list();
    }
}
