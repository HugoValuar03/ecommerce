package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity //Indicação de que a classe está mapeada para uma tabela no banco de dados
public class Acessorios extends Produto {
    
    @Id //Identifica a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Os valores serão gerados automaticamente pelo BD.
    private Long idAcessorio;
    
    @Column
    private TipoAcessorio acessorio;

    @Column
    private Compatibilidade compatibilidade;

    @Column
    private String material;
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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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
