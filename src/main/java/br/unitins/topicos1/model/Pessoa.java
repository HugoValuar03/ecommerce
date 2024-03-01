package br.unitins.topicos1.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
public class Pessoa extends PanacheEntity {

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 300,nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String cargo;

    @Column(length = 60, nullable = false)
    private String cpf;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 200, nullable = false)
    private String endereco;

    @Column(length = 200, nullable = false)
    private String complemento;

    @Column(length = 60, nullable = false)
    private String cidade;

    @Column(length = 30, nullable = false)
    private String estado;

    @Column(length = 11, nullable = false) 
    private String telefone;

    @Column(length = 10, nullable = false)
    private LocalDate aniversario;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public String getEmail() {
        return email;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }
    
}

