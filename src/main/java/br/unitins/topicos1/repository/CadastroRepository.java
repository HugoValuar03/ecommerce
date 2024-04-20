package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Cadastro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class CadastroRepository implements PanacheRepository<Cadastro> {
    public List<Cadastro> findByCategoria(String categoria){
        return find("UPPER(categoria) LIKE ?1", "%" + categoria.toUpperCase() + "%").list();
    }

    public List<Cadastro> findByStatus(String status){
        return find("UPPER(status) LIKE ?1", "%" + status.toUpperCase() + "%").list();
    }

    public List<Cadastro> findByDataCadastro(String dataCadastro){
        return find("UPPER(dataCadastro) LIKE ?1", "%" + dataCadastro.toUpperCase() + "%").list();
    }

    public List<Cadastro> findByDataAlteracao(String dataAlteracao){
        return find("UPPER(dataAlteracao) LIKE ?1", "%" + dataAlteracao.toUpperCase() + "%").list();
    }

}
