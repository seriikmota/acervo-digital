package br.ueg.acervodigital.mapper;

import br.ueg.acervodigital.dto.ImageDTO;
import br.ueg.acervodigital.entities.ItemImage;
import org.mapstruct.*;

import java.util.Base64;
import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ItemImageMapper {
    @Named(value = "toDTOList")
    default ImageDTO toDTOList(ItemImage model) {

        ImageDTO imageDTO = ImageDTO.builder()
                .id(model.getId())
                .image(Base64.getEncoder().encodeToString(model.getImage()))
                .build();

        return imageDTO;
    }

    @IterableMapping(qualifiedByName = "toDTOList")
    List<ImageDTO> fromModelToDTOList(List<ItemImage> ItemImage);
}