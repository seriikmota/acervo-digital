package br.ueg.acervodigital.service.validations.item;

import br.ueg.acervodigital.entities.Item;
import br.ueg.acervodigital.exception.BusinessRuleException;
import br.ueg.acervodigitalarquitetura.enums.ValidationActionsEnum;
import br.ueg.acervodigitalarquitetura.validation.IValidations;
import org.springframework.stereotype.Component;

@Component
public class ItemMandatoryFields implements IValidations<Item> {
    @Override
    public void validate(Item data, ValidationActionsEnum action) {
        if (data.getName() == null || data.getName().isEmpty()) {
            throw new BusinessRuleException("A descrição do item é obrigatória!");
        }
        if (!(data.getApproval() == null)) {
            if (data.getApproval() == Boolean.TRUE && data.getItemImages().isEmpty()) {
                throw new BusinessRuleException("A imagem do item de acervo é obrigatória!");
            }
        }
    }
}
