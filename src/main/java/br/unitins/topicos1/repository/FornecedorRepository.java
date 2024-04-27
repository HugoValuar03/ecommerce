package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {
    
    public List<Fornecedor> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Fornecedor> findByCnpj(String cnpj){
        return find("UPPER(cnpj) LIKE ?1", "%" + cnpj.toUpperCase() + "%").list();
        
    }

    public Fornecedor validarNome(String nome){
        return find("UPPER(nome) LIKE ?1", nome.toUpperCase()).firstResult();
    }
    
}
