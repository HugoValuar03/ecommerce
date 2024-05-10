package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

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

    public Lente(Integer distanciaFocal, String compatibilidade, Integer diametroFiltro, String montagem) {
        this.distanciaFocal = distanciaFocal;
        this.compatibilidade = compatibilidade;
        this.diametroFiltro = diametroFiltro;
        this.montagem = montagem;
    }

    public Lente() {
        
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