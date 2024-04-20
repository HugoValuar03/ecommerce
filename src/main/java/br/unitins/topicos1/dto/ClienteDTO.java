package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

public record ClienteDTO(

    String nome,
    String email,
    String cpf,
    LocalDate aniversario,
    Integer idSexo,
    List<TelefoneDTO> telefones
) {}
