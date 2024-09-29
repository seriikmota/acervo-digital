package br.ueg.acervodigital.service.validations.item;

import br.ueg.acervodigital.entities.Item;
import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.exception.BusinessRuleException;
import br.ueg.acervodigitalarquitetura.enums.ValidationActionsEnum;
import br.ueg.acervodigitalarquitetura.validation.IValidations;
import org.springframework.stereotype.Component;

@Component
public class ItemMandatoryFields implements IValidations<Item> {
    @Override
    public void validate(Item data, ValidationActionsEnum action) {
        if (data.getNumberCode() == null) {
            throw new BusinessRuleException("O código do item é obrigatório!");
        }
        if (data.getName() == null) {
            throw new BusinessRuleException("A descrição do item é obrigatória!");
        }
        if (data.getCollector() == null) {
            throw new BusinessRuleException("O nome de quem coletou o item é obrigatório!");
        }
        if (data.getColleactionYear() == null) {
            throw new BusinessRuleException("O ano que realizou-se a coleta do item é obrigatório!");
        }
    }
}
