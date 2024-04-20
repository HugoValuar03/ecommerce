package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lente extends Produto{

    @Column
    private Integer distanciaFocal;

    @Column
    private String compatibilidade;

    @Column
    private Integer diametroFiltro;

    @Column
    private String montagem;
    
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getDistanciaFocal() {
        return distanciaFocal;
    }

    public void setDistanciaFocal(Integer distanciaFocal) {
        this.distanciaFocal = distanciaFocal;
    }

    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public Integer getDiametroFiltro() {
        return diametroFiltro;
    }

    public void setDiametroFiltro(Integer diametroFiltro) {
        this.diametroFiltro = diametroFiltro;
    }

    public String getMontagem() {
        return montagem;
    }

    public void setMontagem(String montagem) {
        this.montagem = montagem;
    }

    
    
}