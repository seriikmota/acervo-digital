package br.ueg.acervodigital.mapper;

import br.ueg.acervodigital.dto.data.ItemDataDTO;
import br.ueg.acervodigital.dto.general.ItemDTO;
import br.ueg.acervodigital.dto.list.ItemListDTO;
import br.ueg.acervodigital.entities.Item;
import br.ueg.acervodigitalarquitetura.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ItemMapper extends GenericMapper<
        ItemDTO, // DTO Geral
        ItemDataDTO, // DTO Create
        ItemDataDTO, // DTO Update
        ItemListDTO, // DTO List
        Item, // Model
        Long // PK_TYPE
        > {
}