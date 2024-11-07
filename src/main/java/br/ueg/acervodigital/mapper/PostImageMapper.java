package br.ueg.acervodigital.mapper;

import br.ueg.acervodigital.dto.ImageDTO;
import br.ueg.acervodigital.entities.PostImage;
import br.ueg.acervodigitalarquitetura.dto.FileDTO;
import org.mapstruct.*;

import java.util.Base64;
import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PostImageMapper {
    @Mapping(source = "file", target = "image")
    PostImage toModel(FileDTO fileDTO);

    @Named(value = "toDTOList")
    default ImageDTO toDTOList(PostImage model) {

        ImageDTO imageDTO = ImageDTO.builder()
                .id(model.getId())
                .image(Base64.getEncoder().encodeToString(model.getImage()))
                .build();

        return imageDTO;
    }

    @IterableMapping(qualifiedByName = "toDTOList")
    List<ImageDTO> fromModelToDTOList(List<PostImage> PostImage);
}