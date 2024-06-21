package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Camera extends Produto{

    @Column(length = 30, nullable = false)
    private String conectividade;

    @Column(length = 15, nullable = false)
    private String resolucao;

    @Column(length = 5)
    private Boolean telaArticulavel;

    @Column(length = 5)
    private Boolean telaSensivelToque;
    
    @Column(length = 15)
    private String tipoTela;

    @Column(length = 15)
    private String iso;

    @Column(length = 5)
    private Boolean flashPopUp;

    @Column(length = 2)
    private Integer garantia;

    private String nomeImagem;

    @OneToOne
    private Produto produto;

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
} 
