package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity //Indicação de que a classe está mapeada para uma tabela no banco de dados
public class Acessorios {
    
    @Id //Identifica a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Os valores serão gerados automaticamente pelo BD.
    private Long idAcessorio;

    @Column //Adiciona uma coluna na tabela do banco de dados
    @NotBlank(message =  "O campo nome é obrigatório") //Caso o campo não ser preenchido, aparecerá esta mensagem.
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

        TipoAcessorio(String acessorio){  // Construtor que recebe um parâmetro "acessorio" e inicializa o atributo "acessorio"
            this.acessorio = acessorio;
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
