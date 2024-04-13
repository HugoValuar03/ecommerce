package br.unitins.topicos1.model;

import jakarta.persistence.Id;

public enum Sexo {
    MASCULINO(1, "Masculino"),
    FEMININO(2, "Feminino");

    @Id
    private int id;
    
    private String nome;

    private Sexo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Sexo valueOf(Integer id) throws IllegalArgumentException{
        for (Sexo sexo : Sexo.values()) {
            if(sexo.id == id)
                return sexo;
        }
        throw new IllegalArgumentException("id sexo inválido");
    }
}
