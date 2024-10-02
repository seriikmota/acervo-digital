package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.controller.IUserController;
import br.ueg.acervodigital.dto.list.UserListDTO;
import br.ueg.acervodigital.dto.request.UserRequestDTO;
import br.ueg.acervodigital.dto.response.UserResponseDTO;
import br.ueg.acervodigital.service.impl.UserService;
import br.ueg.acervodigitalarquitetura.controller.impl.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<UserRequestDTO, UserResponseDTO, UserListDTO, UserService, Long>
        implements IUserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{id}/access")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void toggleUserAccess(@PathVariable Long id, @RequestParam boolean enable) {
        userService.toggleUserAccess(id, enable);
    }

    @GetMapping("/{id}/enabled")
    @ResponseStatus(HttpStatus.OK)
    public boolean isUserEnabled(@PathVariable Long id) {
        return userService.isUserEnabled(id);
    }
}
