package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Lentes extends Produto{
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLentes;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoMontagem tipoMontagem;
    
    @Column
    @NotBlank(message = "A marca é obrigatória")
    private String marcaLente;
    
    @Column
    @Enumerated(EnumType.STRING)
    private DistanciaFocal distanciaFocal;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Abertura abertura;
    
    @Column 
    @Enumerated(EnumType.STRING)
    private TipoLente tipoLente;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Compatibilidade compatibilidade;
    
    @Column
    private String dimensoes;
    
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;
    
    public void setTipoMontagem(TipoMontagem tipoMontagem) {
        this.tipoMontagem = tipoMontagem;
    }

    public TipoMontagem getTipoMontagem() {
        return tipoMontagem;
    }

    public Long getIdLentes() {
        return idLentes;
    }

    public void setIdLentes(Long idLentes) {
        this.idLentes = idLentes;
    }

    public TipoLente getTipoLente() {
        return tipoLente;
    }

    public void setTipoLente(TipoLente tipoLente) {
        this.tipoLente = tipoLente;
    }

    public String getMarcaLente() {
        return marcaLente;
    }

    public void setMarcaLente(String marcaLente) {
        this.marcaLente = marcaLente;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public DistanciaFocal getDistanciaFocal() {
        return distanciaFocal;
    }

    public void setDistanciaFocal(DistanciaFocal distanciaFocal) {
        this.distanciaFocal = distanciaFocal;
    }

    public Abertura getAbertura() {
        return abertura;
    }

    public void setAbertura(Abertura abertura) {
        this.abertura = abertura;
    }

    public TipoLente getLente() {
        return tipoLente;
    }

    public void setLente(TipoLente tipoLente) {
        this.tipoLente = tipoLente;
    }

    public Compatibilidade getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(Compatibilidade compatibilidade) {
        this.compatibilidade = compatibilidade;
    }


    public enum TipoMontagem{
        CANON_EF("Canon EF"),
        NIKON_F("Nikon F"),
        SONY_E("Sony E"),
        SONY_FE("Sony FE"),
        MFT("Micro Four Third (MFT)"),
        FUJFILM_X("Fujfilm X"),
        PENTAX_K("Pentax K"),
        LEICA_M("Leica M");

        public String getTipoMontagem() {
            return tipoMontagem;
        }

        public void setTipoMontagem(String tipoMontagem) {
            this.tipoMontagem = tipoMontagem;
        }

        private String tipoMontagem;

        TipoMontagem(String montagem){
            this.tipoMontagem=montagem;
        }
    }

    public enum DistanciaFocal{
        WIDE_ANGLE("Grande Angular"),
        ULTRA_WIDE_ANGLE("Ultra Grande Angular"),
        STANDARD("Padrão"),
        TELEPHOTO("Telefoto"),
        SUPER_TELEPHOTO("Super Telefoto"),
        FISHEYE("Olho de Peixe"),
        MACRO("Macro");

        public String distanciaFocal;

        DistanciaFocal(String distanciaFocal){
            this.distanciaFocal = distanciaFocal;
        }
    }

    public enum Abertura{
        F1_4("f/1.4"),
        F2("f/2"),
        F2_8("f/2.8"),
        F4("f/4"),
        F5_6("f/5.6"),
        F8("f/8"),
        F11("f/11"),
        F16("f/16"),
        F22("f/22");

        public String abertura;

        Abertura(String abertura){
            this.abertura = abertura;
        }
    }

    public enum TipoLente{
        PRIME("Lente Prime"),
        ZOOM("Lente Zoom"),
        TILT_SHIFT("Tilt-shift"),
        PERSPECTIVE_CONTROL("Perspective Control"),
        ANAMORPHIC("Anamórfica");

        public String lente;

        TipoLente(String tipoLente){
            this.lente = tipoLente;
        }
    }

    public enum Compatibilidade{
        CANON("Canon"),
        NIKON("Nikon"),
        SONY("Sony"),
        FUJIFILM("Fujifilm"),
        PANASONIC("Panasonic"),
        OLYMPUS("Olympus"),
        PENTAX("Pentax"),
        LEICA("Leica");

        public String compatibilidade;

        Compatibilidade(String compatibilidade) {
            this.compatibilidade = compatibilidade;
        }
    }
}