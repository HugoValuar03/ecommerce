package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Lentes;
import br.unitins.topicos1.model.Lentes.Abertura;
import br.unitins.topicos1.model.Lentes.Compatibilidade;
import br.unitins.topicos1.model.Lentes.DistanciaFocal;
import br.unitins.topicos1.model.Lentes.TipoLente;
import br.unitins.topicos1.model.Lentes.TipoMontagem;

public record LentesResponseDTO(
    String nomeProduto,
    Double preco, 
    TipoMontagem tipoMontagem, 
    String marca, 
    DistanciaFocal distanciaFocal, 
    Abertura abertura, 
    TipoLente lentes, 
    Compatibilidade compatibilidade, 
    String dimensoes, 
    Double peso,
    Fornecedor fornecedor
) {
    public static LentesResponseDTO valueOf(Lentes lentes){
        return new LentesResponseDTO(
            lentes.getNomeProduto(), 
            lentes.getPreco(), 
            lentes.getTipoMontagem(), 
            lentes.getMarca(), 
            lentes.getDistanciaFocal(), 
            lentes.getAbertura(), 
            lentes.getLente(), 
            lentes.getCompatibilidade(), 
            lentes.getDimensoes(), 
            lentes.getPeso(),
            lentes.getFornecedor()
        );
    }
}  
