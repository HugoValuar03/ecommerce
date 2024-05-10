package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente>{
    
    public List<Cliente> findByCpf(String cpf){
        return find("UPPER(pessoa.cpf) LIKE ?1", "%" + cpf.toUpperCase() + "%").list();
    }

    public Cliente validarCpf(String cpf){
        return find("pessoa.cpf LIKE ?1","%" + cpf.toUpperCase() + "%").firstResult();
    }
}
