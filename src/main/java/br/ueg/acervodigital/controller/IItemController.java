package br.ueg.acervodigital.controller;

import br.ueg.acervodigital.dto.list.ItemListDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IItemController {
    ResponseEntity<List<ItemListDTO>> listAllWithoutRole();
    ResponseEntity<List<ItemListDTO>> getByDescription(@PathVariable("description") String description);
}
