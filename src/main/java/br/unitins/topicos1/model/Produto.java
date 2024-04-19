package br.unitins.topicos1.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column
    @NotBlank(message = "Nome da camera é obrigatório")
    private String nomeProduto;
    
    @Column
    private String nomeModelo;

    @Column
    @NotBlank(message = "O preço do produto é obrigatório")
    private Double preco;

    @Column
    private String material;
    
    @Column
    private String dimensoes;

    @ManyToOne
    @JoinColumn(name="idMarca")
    private Marca marca;

    @ManyToMany (mappedBy = "listaProduto")
    private List<Fornecedor> listaFornecedor;


    public Long getIdProduto() {
        return idProduto;
    }


    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }


    public String getNomeProduto() {
        return nomeProduto;
    }


    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }


    public String getNomeModelo() {
        return nomeModelo;
    }


    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }


    public Double getPreco() {
        return preco;
    }


    public void setPreco(Double preco) {
        this.preco = preco;
    }


    public String getMaterial() {
        return material;
    }


    public void setMaterial(String material) {
        this.material = material;
    }


    public String getDimensoes() {
        return dimensoes;
    }


    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public Marca getMarca() {
        return marca;
    }


    public void setMarca(Marca marca) {
        this.marca = marca;
    }


    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }


    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }
    
}
