package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.controller.IUserController;
import br.ueg.acervodigital.dto.list.UserListDTO;
import br.ueg.acervodigital.dto.request.UserRequestDTO;
import br.ueg.acervodigital.dto.response.UserResponseDTO;
import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.entities.UserGroup;
import br.ueg.acervodigital.entities.UserLog;
import br.ueg.acervodigital.mapper.UserMapper;
import br.ueg.acervodigital.service.IUserService;
import br.ueg.acervodigital.service.impl.UserGroupService;
import br.ueg.acervodigital.service.impl.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.ueg.genericarchitecture.controller.impl.AbstractCrudController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.version}/user")
public class UserController extends AbstractCrudController<UserRequestDTO, UserResponseDTO, UserListDTO, User, UserService, UserMapper, Long>
        implements IUserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserGroupService userGroupService;

    @PutMapping("/{id}/access")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole(#root.this.getRoleName('UPDATE'))")
    public void toggleUserAccess(@PathVariable Long id, @RequestParam boolean enable) {
        userService.toggleUserAccess(id, enable);
    }

    @GetMapping("/{id}/enabled")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole(#root.this.getRoleName('READ'))")
    public boolean isUserEnabled(@PathVariable Long id) {
        return userService.isUserEnabled(id);
    }

    @GetMapping("/getLogUsers")
    @PreAuthorize("hasRole(#root.this.getRoleName('LOG_LISTALL'))")
    public ResponseEntity<Page<UserLog>> getLogUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.getLogUsers(pageable));
    }

    @GetMapping("/getUserGroup")
    @PreAuthorize("hasRole(#root.this.getRoleName('READ'))")
    public ResponseEntity<List<UserGroup>> getUserGroup() {
        return ResponseEntity.ok(userGroupService.findAll());
    }
}
