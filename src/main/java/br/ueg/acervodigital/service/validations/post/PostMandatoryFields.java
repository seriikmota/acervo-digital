package br.ueg.acervodigital.service.validations.post;

import br.ueg.acervodigital.entities.Post;
import br.ueg.acervodigital.enums.ErrorEnum;
import br.ueg.genericarchitecture.enums.ValidationActionsEnum;
import br.ueg.genericarchitecture.exception.Message;
import br.ueg.genericarchitecture.validation.IValidations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostMandatoryFields implements IValidations<Post> {
    @Override
    public void validate(Post data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (data.getTitle() == null || data.getTitle().isEmpty()) {
            messagesToThrow.add(new Message(ErrorEnum.MANDATORY_FIELD, "'titulo'"));
        }
        if (data.getTag() == null || data.getTag().isEmpty()) {
            messagesToThrow.add(new Message(ErrorEnum.MANDATORY_FIELD, "'tags'"));
        }
        if (data.getContent() == null || data.getContent().isEmpty()) {
            messagesToThrow.add(new Message(ErrorEnum.MANDATORY_FIELD, "'conteudo'"));
        }
        if (!(data.getApproval() == null)) {
            if (data.getApproval() == Boolean.TRUE && data.getImages().isEmpty()) {
                messagesToThrow.add(new Message(ErrorEnum.MANDATORY_FIELD, "'imagem'"));
            }
        }
    }
}
