package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record PessoaDTO(

    String nome,
    String email,
    String cpf,
    Integer idSexo,
    LocalDate aniversario,
    TelefoneDTO telefone    
){}
