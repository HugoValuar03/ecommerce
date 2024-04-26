package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;

public record TelefoneDTO(
    String codigoArea,
    String numero
) {
    public static Telefone convertToTelefone(TelefoneDTO telefoneDto){
        Telefone telefone = new Telefone();

        telefone.setCodigoArea(telefoneDto.codigoArea());
        telefone.setNumero(telefoneDto.numero());
        return telefone;
    }
}
