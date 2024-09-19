package br.ueg.acervodigital.controller;

import br.ueg.acervodigital.dto.general.ItemDTO;
import br.ueg.acervodigital.dto.list.ItemListDTO;
import br.ueg.acervodigital.dto.data.ItemDataDTO;
import br.ueg.acervodigital.entities.Item;
import br.ueg.acervodigital.mapper.ItemMapper;
import br.ueg.acervodigital.service.ItemService;
import br.ueg.acervodigitalarquitetura.controller.GenericCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${app.api.base}/person")
public class ItemController extends
        GenericCRUDController<
                        ItemDTO, // DTO Geral
                        ItemDataDTO, // DTO Create
                        ItemDataDTO, // DTO Update
                        ItemListDTO,
                        Item, // Modelo
                        Long, // PK_TYPE
                        ItemService, //Interface Serviço
                        ItemMapper> // Mapper
{

}