package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa>{
    
    public List<Pessoa> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Pessoa> findByCpf(String cpf){
        return find("UPPER(cpf) LIKE ?1", "%" + cpf.toUpperCase() + "%").list();
    }

    public Pessoa validarCpf(String cpf){
        return find("UPPER(cpf) LIKE ?1", cpf.toUpperCase()).firstResult();
    }
}
