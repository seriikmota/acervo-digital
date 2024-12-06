package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.service.impl.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/initializer")
public class InitializerController {

    @Autowired
    private InitializerService initializerService;

    @PutMapping("/{password}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void initializerRoles(@PathVariable String password) {
        initializerService.initializerRoles(password);
    }

}
