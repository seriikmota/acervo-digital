package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.controller.IItemController;
import br.ueg.acervodigital.controller.IUserController;
import br.ueg.acervodigital.dto.list.ItemListDTO;
import br.ueg.acervodigital.dto.request.ItemRequestDTO;
import br.ueg.acervodigital.dto.response.ItemResponseDTO;
import br.ueg.acervodigital.service.impl.ItemService;
import br.ueg.acervodigitalarquitetura.controller.impl.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version}/item")
public class ItemController extends AbstractCrudController<ItemRequestDTO, ItemResponseDTO, ItemListDTO, ItemService, Long>
        implements IItemController {
}
