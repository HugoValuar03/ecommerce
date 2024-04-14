package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

public record PessoaDTO(

    String nome,
    String email,
    String cpf,
    Integer idSexo,
    LocalDate aniversario,
    List<TelefoneDTO> listaTelefone
    
){}
