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
public class Bolsas extends Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Modelo modelo;

    @Column
    @Enumerated(EnumType.STRING)
    private Cor cor;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    // public enum Marca {
    //     LOWEPRO("Lowepro"),
    //     PEAK_DESIGN("Peak Design"),
    //     THINK_TANK_PHOTO("Think Tank Photo"),
    //     MANFROTTO("Manfrotto"),
    //     BILLINGHAM("Billigham"),
    //     TENBA("Tenba"),
    //     DOMKE("Domke"),
    //     ONA("Ona");
        
	//     public String descricao;

    //     Marca(String descricao){ 
    //         this.descricao = descricao;
    //     }
    // }

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
