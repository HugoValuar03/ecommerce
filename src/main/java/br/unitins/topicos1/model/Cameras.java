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

@Entity
public class Cameras extends Produto{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCameras;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Sensor sensor;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Processador processador;

    @Column
    private String resolucao;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Lentes lente;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Bateria bateria;
    
    @Column
    @Enumerated(EnumType.STRING)
    private FormatoAudio formatoAudio;
    
    @Column
    @Enumerated(EnumType.STRING)
    private FormatoVideo formatoVideo;
    
    @Column
    @Enumerated(EnumType.STRING)
    private FormatoImagem formatoImagem;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Iso iso;

    @Column
    @Enumerated(EnumType.STRING)
    private Obturador obturador;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    public Long getIdCameras() {
        return idCameras;
    }

    public void setIdCameras(Long idCameras) {
        this.idCameras = idCameras;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Processador getProcessador() {
        return processador;
    }

    public void setProcessador(Processador processador) {
        this.processador = processador;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public Lentes getLente() {
        return lente;
    }

    public void setLente(Lentes lente) {
        this.lente = lente;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    public FormatoAudio getFormatoAudio() {
        return formatoAudio;
    }

    public void setFormatoAudio(FormatoAudio formatoAudio) {
        this.formatoAudio = formatoAudio;
    }

    public FormatoVideo getFormatoVideo() {
        return formatoVideo;
    }

    public void setFormatoVideo(FormatoVideo formatoVideo) {
        this.formatoVideo = formatoVideo;
    }

    public FormatoImagem getFormatoImagem() {
        return formatoImagem;
    }

    public void setFormatoImagem(FormatoImagem formatoImagem) {
        this.formatoImagem = formatoImagem;
    }

    public Iso getIso() {
        return iso;
    }

    public void setIso(Iso iso) {
        this.iso = iso;
    }

    public Obturador getObturador() {
        return obturador;
    }

    public void setObturador(Obturador obturador) {
        this.obturador = obturador;
    }

    public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

    // public enum Marca{

    //     CANON("Canon"),
    //     NIKON("Nikon"),
    //     SONY("Sony"),
    //     FUJFILM("Fujfilm"),
    //     PANASONIC("Panasonic");
    
    //     public String marca;
    
    //     Marca(String marca){
    //         this.marca = marca;
    //     }
    // }

    public enum Sensor{
        FULL_FRAME("Full Frame"),
        ASP_H("ASP-H"),
        ASP_C("ASP-C"),
        MICRO_FOUR_THIRDS("Micro Four Thirds"),
        MEDIUM_FORMAT("Medium Format"),
        CX("CX"),
        CCD( "CCD" ),
        CMOS("CMOS");

        public String sensor;

        Sensor(String  sensor) {
            this.sensor = sensor;
        }
    }

    public enum Processador{
        DIGIC("Digic"),
        EXPEED("Expeed"),
        BIONZ("Bionz"),
        DIGIC_X("Digic X"),
        X_PROCESSOR("X-Processor"),
        PRIME("PRIME (PENTAX REAL IMAGE ENGINE)");

        public String processador;

        Processador(String processador){
            this.processador = processador;
        }
    }

    public enum Lentes{
        LENTE_50MM("Lente 50mm f/1.8"),
        LENTE_24_70MM("Lente 24-70mm f/2.8"),
        LENTE_70_200MM("Lente 70-200mm f/2.8"),
        LENTE_MACRO("Lente Macro 100mm f/2.8"),
        LENTE_FISHEYE("Lente fisheye 8mm f/3.5"),
        LENTE_TILT_SHIFT("Lente Tilt-Shift 24mm f/3.5"),
        LENTE_PRIME("Lente Prime 85mm f/1.4"),
        LENTE_SUPERZOOM("Lente Superzoom 18-300mm f/3.5-6.3");

        public String lente;

        Lentes(String lente){
            this.lente = lente;
        }
    }

    public enum Bateria{
        BATERIA_LITHIUM_ION("Bateria de Íon de Lítio"),
        BATERIA_NIMH("Bateria NiMH (Níquel-Metal Hidreto)"),
        BATERIA_ALCALINA("Bateria Alcalina"),
        BATERIA_RECARREGAVEL("Bateria Recarregável"),
        BATERIA_LITIO_RECARGAVEL("Bateria de Lítio Recarregável"),
        BATERIA_ZINCO_AR("Bateria de Zinco-Ar"),
        BATERIA_LITIO_AR("Bateria de Lítio-Ar");

        public String bateria;

        Bateria(String bateria){
            this.bateria = bateria;
        }
    }

    public enum FormatoVideo{
        MP4("MP4"),
        AVI("AVI"),
        MOV("MOV"),
        WMV("MWV"),
        MKV("WMV"),
        FLV("FLV");
    
        public String formatoVideo;
    
        FormatoVideo(String formato){
            this.formatoVideo = formato;
        }
    }

    public enum FormatoAudio{
        MP3("MP3"),
        WAV("WAV"),
        FLAC("FLAC"),
        AAC("AAC"),
        OGG("OGG");
    
        public String formatoAudio;
    
        FormatoAudio(String formato){
            this.formatoAudio = formato;
        }
    }
    public enum FormatoImagem{
        JPEG("JPEG"),
        PNG("PNG"),
        TIFF("TIFF"),
        RAW("RAW"),
        DNG("DNG");

        public String formatoImagem;
    
        FormatoImagem(String formato){
            this.formatoImagem = formato;
        }
    }
    public enum Iso{
        ISO_100(100),
        ISO_200(200),
        ISO_400(400),
        ISO_800(800),
        ISO_1600(1600),
        ISO_3200(3200);
    
        public Integer iso;
    
        Iso(Integer iso){
            this.iso = iso;
        }
    }
    public enum Obturador{
        OBTURADOR_ELETRONICO("Obturador Eletrônico"),
        OBTURADOR_MECANICO("Obturador Mecânico"),
        OBTURADOR_ELETRONICO_MECANICO("Obturador Eletrônico e Mecânico");
    
        public String obturador;
    
        Obturador(String obturador){
            this.obturador = obturador;
        }
    }
    
	
} 