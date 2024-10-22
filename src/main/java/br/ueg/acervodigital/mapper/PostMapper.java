package br.ueg.acervodigital.mapper;

import br.ueg.acervodigital.dto.list.PostListDTO;
import br.ueg.acervodigital.dto.request.PostRequestDTO;
import br.ueg.acervodigital.dto.response.PostResponseDTO;
import br.ueg.acervodigital.entities.Post;
import br.ueg.acervodigitalarquitetura.mapper.GenericMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PostMapper extends GenericMapper<PostRequestDTO, PostResponseDTO, PostListDTO, Post, Long> {
    @Named(value = "toDTOList") // para identificar o nome desse método pelo mapstruct
    PostListDTO toDTOList(Post model);

    @IterableMapping(qualifiedByName = "toDTOList") // para orientar qual método utilizar no caso de vários target=source;
    List<PostListDTO> fromModelToDTOList(List<Post> posts);
}
