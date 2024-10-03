package br.ueg.acervodigital.service.impl;

import br.ueg.acervodigital.dto.list.ItemListDTO;
import br.ueg.acervodigital.dto.request.ItemRequestDTO;
import br.ueg.acervodigital.dto.response.ItemResponseDTO;
import br.ueg.acervodigital.entities.Item;
import br.ueg.acervodigital.mapper.ItemMapper;
import br.ueg.acervodigital.repository.ItemRepository;
import br.ueg.acervodigital.service.IItemService;
import br.ueg.acervodigitalarquitetura.exception.DataException;
import br.ueg.acervodigitalarquitetura.service.impl.AbstractService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ItemService extends AbstractService<ItemRequestDTO, ItemResponseDTO, ItemListDTO, Item, ItemRepository, ItemMapper, Long>
        implements IItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    protected void prepareToCreate(Item data) {
    }

    @Override
    protected void prepareToUpdate(Item dataDB) {

    }

    @Override
    protected void prepareToDelete(Item dataDB) {

    }

    public List<Item> getByDescription(String description) {
        List<Item> temp = repository.findByNameContaining(description);
        if(temp.isEmpty()){
            throw new DataException("Item do acervo não encontrado");
        }
        return temp;
    }
}
