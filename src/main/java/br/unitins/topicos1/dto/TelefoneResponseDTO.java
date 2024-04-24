package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;

public record TelefoneResponseDTO(Long idTelefone, String codigoArea, String numero) {
    public static TelefoneResponseDTO valueOf(Telefone telefone){
        return new TelefoneResponseDTO(
            telefone.getId(),
            telefone.getCodigoArea(),
            telefone.getNumero()
        );
    }
}
