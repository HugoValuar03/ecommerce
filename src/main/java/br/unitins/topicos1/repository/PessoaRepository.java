package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped // Significa que uma única instância desse bean será compartilhada por toda a aplicação durante sua vida útil.
public class PessoaRepository implements PanacheRepository<Pessoa>{

    @Transactional// Se o método for bem-sucedido, todas as alterações no banco de dados serão confirmadas quando a transação for concluída. 
    
    public List<Pessoa> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase()  + "%").list();
        //Independente do que for digitado, procurará um nome que tenha esta letra no meio da palavra
    }

    public List<Pessoa> findByCargo(String cargo){
        return find("UPPER(cargo) LIKE ?1","%" + cargo.toUpperCase() + "%").list();
        // Independente do que for digitado, procurará um cargo que tenha esta letra no meio da palavra
    }
}
