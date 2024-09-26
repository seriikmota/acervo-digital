package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.controller.IUserController;
import br.ueg.acervodigital.dto.list.UserListDTO;
import br.ueg.acervodigital.dto.request.UserRequestDTO;
import br.ueg.acervodigital.dto.response.UserResponseDTO;
import br.ueg.acervodigital.service.impl.UserService;
import br.ueg.acervodigitalarquitetura.controller.impl.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version}/user")
public class UserController extends AbstractCrudController<UserRequestDTO, UserResponseDTO, UserListDTO, UserService, Long>
        implements IUserController {
}
