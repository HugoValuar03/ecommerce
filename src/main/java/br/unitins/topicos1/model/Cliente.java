package br.unitins.topicos1.model;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Cliente extends Pessoa {

    @Id
    private Long idCliente;

    @OneToOne
    private Pessoa pessoa;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
