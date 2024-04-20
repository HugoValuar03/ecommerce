package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Camera extends Produto{

    @Column
    private String conectividade;

    @Column 
    private String resolucao;

    @Column
    private Boolean telaArticulavel;

    @Column
    private Boolean telaSensivelToque;
    
    @Column
    private String tipoTela;

    @Column
    private String iso;

    @Column
    private Boolean flashPopUp;

    @Column 
    private Integer garantia;

    public String getConectividade() {
        return conectividade;
    }

    public void setConectividade(String conectividade) {
        this.conectividade = conectividade;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public Boolean getTelaArticulavel() {
        return telaArticulavel;
    }

    public void setTelaArticulavel(Boolean telaArticulavel) {
        this.telaArticulavel = telaArticulavel;
    }

    public Boolean getTelaSensivelToque() {
        return telaSensivelToque;
    }

    public void setTelaSensivelToque(Boolean telaSensivelToque) {
        this.telaSensivelToque = telaSensivelToque;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Boolean getFlashPopUp() {
        return flashPopUp;
    }

    public void setFlashPopUp(Boolean flashPopUp) {
        this.flashPopUp = flashPopUp;
    }

    public Integer getGarantia() {
        return garantia;
    }

    public void setGarantia(Integer garantia) {
        this.garantia = garantia;
    }
 
} 
