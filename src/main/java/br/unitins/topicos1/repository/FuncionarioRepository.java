package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped // Significa que uma única instância desse bean será compartilhada por toda a aplicação durante sua vida útil.
public class FuncionarioRepository implements PanacheRepository<Funcionario>{
    
    public List<Funcionario> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase()  + "%").list();
        //Independente do que for digitado, procurará um nome que tenha esta letra no meio da palavra
    }

    public List<Funcionario> findByCargo(String cargo){
        return find("UPPER(cargo) LIKE ?1","%" + cargo.toUpperCase() + "%").list();
        // Independente do que for digitado, procurará um cargo que tenha esta letra no meio da palavra
    }
}
