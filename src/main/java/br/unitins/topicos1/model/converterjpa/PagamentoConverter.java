package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.FormaPagamento;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PagamentoConverter implements AttributeConverter<FormaPagamento, Integer> {

    @Override
    public Integer convertToDatabaseColumn(FormaPagamento pagamento) {
        return pagamento.getId();
    }

    @Override
    public FormaPagamento convertToEntityAttribute(Integer id) {
        return FormaPagamento.valueOf(id);
    }
    
}
