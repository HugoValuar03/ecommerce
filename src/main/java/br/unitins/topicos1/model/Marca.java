package br.unitins.topicos1.model;

import jakarta.persistence.Id;

public class Marca {
    
    @Id
    private Long idMarca;

    private String nome;

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
