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
}
