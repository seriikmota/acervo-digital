package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.controller.IItemController;
import br.ueg.acervodigital.dto.list.ItemListDTO;
import br.ueg.acervodigital.dto.request.ItemRequestDTO;
import br.ueg.acervodigital.dto.response.ItemResponseDTO;
import br.ueg.acervodigital.mapper.ItemMapper;
import br.ueg.acervodigital.service.impl.ItemService;
import br.ueg.acervodigitalarquitetura.controller.impl.AbstractCrudFileController;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.version}/item")
public class ItemController extends AbstractCrudFileController<ItemRequestDTO, ItemResponseDTO, ItemListDTO, ItemService, Long>
        implements IItemController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected ItemService service;
    @Autowired
    protected ItemMapper mapper;

    @GetMapping("/list")
    public ResponseEntity<List<ItemListDTO>> listAllWithoutRole(){
        List<ItemListDTO> listDTO = service.listAll();
        return ResponseEntity.ok(listDTO);
    }

    @GetMapping(path = "/search/{description}")
    @Operation(description = "End point para obter dados por descrição")
    public ResponseEntity<List<ItemListDTO>> getByDescription(
            @PathVariable("description") String description
    ) {
        List<ItemListDTO> modelList = mapper.toDtoList(service.getByDescription(description));
        return ResponseEntity.of(
                Optional.ofNullable(modelList)
        );
    }
}
