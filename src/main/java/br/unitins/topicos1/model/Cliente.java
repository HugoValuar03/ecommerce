package br.unitins.topicos1.model;

import jakarta.persistence.Id;

public class Cliente extends Pessoa {

    @Id
    private Long idCliente;


    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

}
