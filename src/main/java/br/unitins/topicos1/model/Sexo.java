package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Sexo {
    MASCULINO(1, "Masculino"),
    FEMININO(2, "Feminino");

    private int id;
    private String sexo;

    private Sexo(int id, String sexo) {
        this.id = id;
        this.sexo = sexo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public static Sexo valueOf(Integer id) throws IllegalArgumentException{
        for (Sexo sexo : Sexo.values()) {
            if(sexo.id == id)
                return sexo;
        }
        throw new IllegalArgumentException("id sexo inválido");
    }
}
