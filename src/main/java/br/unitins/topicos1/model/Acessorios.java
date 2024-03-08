package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Integer altura;

    @Column 
    private Integer largura;

    @Column
    private String material;

    @Column 
    private Double peso;

    @Column 
    private Cor cor;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;
    
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
	public Long getIdAcessorio() {
		return idAcessorio;
	}

	public void setIdAcessorio(Long idAcessorio) {
		this.idAcessorio = idAcessorio;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public TipoAcessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(TipoAcessorio acessorio) {
		this.acessorio = acessorio;
	}

	public Compatibilidade getCompatibilidade() {
		return compatibilidade;
	}

	public void setCompatibilidade(Compatibilidade compatibilidade) {
		this.compatibilidade = compatibilidade;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getLargura() {
		return largura;
	}

	public void setLargura(Integer largura) {
		this.largura = largura;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
    
}
