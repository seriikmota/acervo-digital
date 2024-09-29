package br.ueg.acervodigital.mapper;

import br.ueg.acervodigital.dto.list.ItemListDTO;
import br.ueg.acervodigital.dto.request.ItemRequestDTO;
import br.ueg.acervodigital.dto.response.ItemResponseDTO;
import br.ueg.acervodigital.entities.Item;
import br.ueg.acervodigitalarquitetura.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ItemMapper extends GenericMapper<ItemRequestDTO, ItemResponseDTO, ItemListDTO, Item, Long> {
    @Named(value = "toDTOList") // para identificar o nome desse metodo pelo mapstruct
    ItemListDTO toDTOList(Item model);

    @IterableMapping(qualifiedByName = "toDTOList") // para orientar qual metodo utilizar no caso de vários target=source;
    List<ItemListDTO> fromModelToDTOList(List<Item> items);
}
