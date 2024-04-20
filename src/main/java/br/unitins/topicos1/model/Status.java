package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {
    ATIVO(1, "Ativo"),
    INATIVO(2, "Inativo"),
    PENDENTE(3, "Pendente");

    private int id;
    private String nome;

    private Status(int id, String nome) {
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

    public static Status valueOf(Integer id) throws IllegalArgumentException{
        for (Status status : Status.values()) {
            if(status.id == id)
                return status;            
        }

        throw new IllegalArgumentException("id Status inválido");
    }

}
