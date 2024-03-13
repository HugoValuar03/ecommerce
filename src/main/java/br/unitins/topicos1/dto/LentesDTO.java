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
    String nomeProduto, 

    @NotBlank(message = "Preco é obrigatório")
    @Size(min = 4, max = 10, message = "O Tamanho deve ser entre 3 e 65 caracteres")
    Double preco, 

    @NotBlank(message = "Tipo de montagem necessaria")
    TipoMontagem tipoMontagem, 

    @NotBlank(message = "Marca de lente necessario")
    @Size(min = 3, max = 10, message = "Deve ter entre 3 e 10 caracteres")
    String marca, 

    @NotBlank(message = "Marca de lente necessario")
    @Size(min = 3, max = 10, message = "Deve ter entre 3 e 10 caracteres")
    String material,

    @NotBlank(message = "Distancia focal da lente necessaria")
    DistanciaFocal distanciaFocal, 

    @NotBlank(message = "Abertura da lente é necessaria")
    Abertura abertura, 

    @NotBlank(message = "Tipo da lente necessaria")
    TipoLente lentes, 

    @NotBlank(message = "compatibilidade da lente necessaria")
    Compatibilidade compatibilidade, 

    @NotBlank(message = "Dimensões lente necessario")
    @Size(min = 8, max = 13)
    String dimensoes, 

    @NotBlank(message = "Peso da lente necessario")
    @Size(min = 1, max = 4)
    Double peso,

    @NotBlank(message = "Coloque o fornecedor")
    Fornecedor fornecedor
) {}

