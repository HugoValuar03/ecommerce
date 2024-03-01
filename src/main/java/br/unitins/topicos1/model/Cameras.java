package br.unitins.topicos1.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class Cameras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da camera é obrigatório")
    private String nome;

    @NotBlank(message = "O preço do produto é obrigatório")
    private Double preco;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    @Enumerated(EnumType.STRING)
    private Sensor sensor;

    @Enumerated(EnumType.STRING)
    private Processador processador;

    private String resolucao;

    @Enumerated(EnumType.STRING)
    private Lente lente;

    @Enumerated(EnumType.STRING)
    private Bateria bateria;

    @Enumerated(EnumType.STRING)
    private FormatoAudio formatoAudio;

    @Enumerated(EnumType.STRING)
    private FormatoVideo formatoVideo;
    
    @Enumerated(EnumType.STRING)
    private FormatoImagem formatoImagem;

    @Enumerated(EnumType.STRING)
    private Iso iso;

    @Enumerated(EnumType.STRING)
    private Obturador obturador;

    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
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

    public Lente getLente() {
        return lente;
    }

    public void setLente(Lente lente) {
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

    public enum Marca{

        CANON("Canon"),
        NIKON("Nikon"),
        SONY("Sony"),
        FUJFILM("Fujfilm"),
        PANASONIC("Panasonic");
    
        private String marca;
    
        Marca(String marca){
            this.marca = marca;
        }
    }

    public enum Sensor{
        FULL_FRAME("Full Frame"),
        ASP_H("ASP-H"),
        ASP_C("ASP-C"),
        MICRO_FOUR_THIRDS("Micro Four Thirds"),
        MEDIUM_FORMAT("Medium Format"),
        CX("CX"),
        CCD( "CCD" ),
        CMOS("CMOS");

        private String sensor;

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

        private String processador;

        Processador(String processador){
            this.processador = processador;
        }
    }

    public enum Lente{
        LENTE_50MM("Lente 50mm f/1.8"),
        LENTE_24_70MM("Lente 24-70mm f/2.8"),
        LENTE_70_200MM("Lente 70-200mm f/2.8"),
        LENTE_MACRO("Lente Macro 100mm f/2.8"),
        LENTE_FISHEYE("Lente fisheye 8mm f/3.5"),
        LENTE_TILT_SHIFT("Lente Tilt-Shift 24mm f/3.5"),
        LENTE_PRIME("Lente Prime 85mm f/1.4"),
        LENTE_SUPERZOOM("Lente Superzoom 18-300mm f/3.5-6.3");

        private String lente;

        Lente(String lente){
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

        private String bateria;

        Bateria(String bateria){
            this.bateria = bateria;
        }
    }

    public enum FormatoVideo{
        MPEG_4("MPEG-4"),
        AVCHD("AVCHD"),
        H_264("H.264"),
        H_265("H.265"),
        MOV("MOV"),
        MP4("MP4"),
        WMV("WMV"),
        FLV("FLV");
    
        private String formatoVideo;
    
        FormatoVideo(String formato){
            this.formatoVideo = formato;
        }
    }

    public enum FormatoAudio{
        PCM("PCM"),
        AAC("AAC"),
        MP3("MP3"),
        WAV("WAV"),
        AIFF("AIFF"),
        FLAC("FLAC"),
        ALAC("ALAC"),
        OGG("OGG");
    
        private String formatoAudio;
    
        FormatoAudio(String formato){
            this.formatoAudio = formato;
        }
    }
    public enum FormatoImagem{
        JPEG("JPEG"),
        PNG("PNG"),
        TIFF("TIFF"),
        RAW("RAW"),
        DNG("DNG"),
        GIF("GIF"),
        BMP("BMP"),
        WEBP("WEBP");
    
        private String formatoImagem;
    
        FormatoImagem(String formato){
            this.formatoImagem = formato;
        }
    }
    public enum Iso{
        JPEG("JPEG"),
        PNG("PNG"),
        TIFF("TIFF"),
        RAW("RAW"),
        DNG("DNG"),
        GIF("GIF"),
        BMP("BMP"),
        WEBP("WEBP");
    
        private String iso;
    
        Iso(String iso){
            this.iso = iso;
        }
    }
    public enum Obturador{
        OBTURADOR_ELETRONICO("Obturador Eletrônico"),
        OBTURADOR_MECANICO("Obturador Mecânico"),
        OBTURADOR_ELETRONICO_MECANICO("Obturador Eletrônico e Mecânico");
    
        private String obturador;
    
        Obturador(String obturador){
            this.obturador = obturador;
        }
    }
}