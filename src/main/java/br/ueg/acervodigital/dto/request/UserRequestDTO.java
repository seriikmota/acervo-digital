package br.ueg.acervodigital.dto.request;

import br.ueg.acervodigital.entities.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private Long id;
    private String name;
    private String login;
    private String email;
    private String password;
    private String confirmPassword;
    private UserGroup userGroup;
    private Boolean enabled;
}
