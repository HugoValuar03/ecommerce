package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Bolsas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @Column
    @NotBlank(message = "Coloque o preço")
    private Double valor;

    @Column
    @Enumerated(EnumType.STRING)
    private Marca marca;

    @Column
    @Enumerated(EnumType.STRING)
    private Modelo modelo;

    @Column
    @Enumerated(EnumType.STRING)
    private Cor cor;

    @Column
    private Double largura;

    @Column
    private Double altura;

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Double getValor() {
        return valor;
    }


    public void setValor(Double valor) {
        this.valor = valor;
    }


    public Marca getMarca() {
        return marca;
    }


    public void setMarca(Marca marca) {
        this.marca = marca;
    }


    public Modelo getModelo() {
        return modelo;
    }


    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }


    public Cor getCor() {
        return cor;
    }


    public void setCor(Cor cor) {
        this.cor = cor;
    }


    public Double getLargura() {
        return largura;
    }


    public void setLargura(Double largura) {
        this.largura = largura;
    }


    public Double getAltura() {
        return altura;
    }


    public void setAltura(Double altura) {
        this.altura = altura;
    }


    public enum Marca {
        LOWEPRO("Lowepro"),
        PEAK_DESIGN("Peak Design"),
        THINK_TANK_PHOTO("Think Tank Photo"),
        MANFROTTO("Manfrotto"),
        BILLINGHAM("Billigham"),
        TENBA("Tenba"),
        DOMKE("Domke"),
        ONA("Ona");
        
	    public String descricao;

        Marca(String descricao){ 
            this.descricao = descricao;
        }
    }

    public enum Modelo{
        BACKPACK("Mochila"),
        SHOULDER_BAG("Bolsa de Ombro"),
        SLING_BAG("Bolsa Sling"),
        ROLLER_BAG("Bolsa de Rodinhas"),
        MESSENGER_BAG("Bolsa Mensageiro"),
        HARDCASE("Case Rígido"),
        BELT_PACK("Bolsa Cinto");

        public String modelo;

        Modelo(String modelo){
            this.modelo = modelo;
        }
    }


    public enum Cor{
        PRETO("Preto"),
        CINZA("Cinza"),
        PRETO_VERMELHO("Preto com Vermelho");

        public String cor;

        Cor(String cor){
            this.cor = cor;
        }
    }
}
