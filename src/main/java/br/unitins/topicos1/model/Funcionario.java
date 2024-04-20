package br.unitins.topicos1.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Funcionario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    private String cargo;

    @OneToOne
    @JoinColumn(name = "idpessoa", unique = true)
    private Pessoa pessoa;

    @OneToMany
    @JoinColumn(name = "idCadastro")
    private List<Cadastro> cadastro;

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Cadastro> getCadastro() {
        return cadastro;
    }

    public void setCadastro(List<Cadastro> cadastro) {
        this.cadastro = cadastro;
    }

}

