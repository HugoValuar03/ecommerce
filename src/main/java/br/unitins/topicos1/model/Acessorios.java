package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Acessorios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcessorio;

    @Column
    @NotBlank(message =  "O campo nome é obrigatório")
    private String nomeProduto;

    @Column
    @NotBlank(message = "O campo de preço é obrigatório")
    private  Double preco;
    
    @Column
    private TipoAcessorio acessorio;

    @Column
    private Compatibilidade compatibilidade;

    @Column
    private Double altura;

    @Column 
    private Double largura;

    @Column
    private String Material;

    @Column 
    private Double peso;

    @Column 
    private Cor cor;
    
    public enum TipoAcessorio{
        TRIPE("Tripé"),
        FILTROS("Filtro"),
        FLASHS("Flashs"),
        BATERIAS("Baterias");

        public String acessorio;

        TipoAcessorio(String acessorio){
            this.acessorio= acessorio;
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

    public enum Cor{
        PRETO("Preto"),
        BRANCO("Branco");

        public String cor;

        Cor(String cor){
            this.cor = cor;
        }
    }
}
