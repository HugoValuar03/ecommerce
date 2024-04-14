package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Lentes.Abertura;
import br.unitins.topicos1.model.Lentes.Compatibilidade;
import br.unitins.topicos1.model.Lentes.DistanciaFocal;
import br.unitins.topicos1.model.Lentes.TipoLente;
import br.unitins.topicos1.model.Lentes.TipoMontagem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LentesDTO(
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 65, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    String nomeProduto

    
) {}

