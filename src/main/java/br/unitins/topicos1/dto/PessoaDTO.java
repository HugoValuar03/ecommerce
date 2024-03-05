package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record PessoaDTO(String nome, String email, String cargo, String cpf, String cep, String endereco, String complemento, String cidade, String estado, String telefone, LocalDate aniversario, Long id) {}
    /*
    @Column(length = 200, nullable = false)
    private String nome;
    
    @Column(length = 300,nullable = false)
    private String email;
    
    @Column(length = 60, nullable = false)
    private String cargo;

    @Column(length = 60, nullable = false)
    private String cpf;
    
    @Column(length = 8, nullable = false)
    private String cep;
    
    @Column(length = 200, nullable = false)
    private String endereco;
    
    @Column(length = 200, nullable = false)
    private String complemento;
    
    @Column(length = 60, nullable = false)
    private String cidade;

    @Column(length = 30, nullable = false)
    private String estado;
    
    @Column(length = 11, nullable = false) 
    private String telefone;
    
    @Column(length = 10, nullable = false)
    private LocalDate aniversario;
     */
