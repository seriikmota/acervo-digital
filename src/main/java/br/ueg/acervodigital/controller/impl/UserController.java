package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.controller.IUserController;
import br.ueg.acervodigital.dto.list.UserListDTO;
import br.ueg.acervodigital.dto.request.UserRequestDTO;
import br.ueg.acervodigital.dto.response.UserResponseDTO;
import br.ueg.acervodigital.service.impl.UserService;
import br.ueg.acervodigitalarquitetura.controller.impl.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version}/user")
public class UserController extends AbstractController<UserRequestDTO, UserResponseDTO, UserListDTO, UserService, Long>
        implements IUserController {
}
