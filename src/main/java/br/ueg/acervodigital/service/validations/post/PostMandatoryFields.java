package br.ueg.acervodigital.service.validations.post;

import br.ueg.acervodigital.entities.Post;
import br.ueg.acervodigital.exception.BusinessRuleException;
import br.ueg.acervodigitalarquitetura.enums.ValidationActionsEnum;
import br.ueg.acervodigitalarquitetura.validation.IValidations;
import org.springframework.stereotype.Component;

@Component
public class PostMandatoryFields implements IValidations<Post> {
    @Override
    public void validate(Post data, ValidationActionsEnum action) {
        if (data.getTitle() == null || data.getTitle().isEmpty()) {
            throw new BusinessRuleException("O título da postagem é obrigatório!");
        }
        if (data.getTag() == null || data.getTag().isEmpty()) {
            throw new BusinessRuleException("A etiqueta da postagem é obrigatória!");
        }
        if (data.getContent() == null || data.getContent().isEmpty()) {
            throw new BusinessRuleException("O conteúdo da postagem é obrigatório!");
        }
        if (!(data.getApproval() == null)) {
            if (data.getApproval() == Boolean.TRUE && data.getPostImages().isEmpty()) {
                throw new BusinessRuleException("A imagem da postagem é obrigatória!");
            }
        }
    }
}
