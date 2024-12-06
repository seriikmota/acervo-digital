package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.controller.IPostController;
import br.ueg.acervodigital.dto.list.PostListDTO;
import br.ueg.acervodigital.dto.request.PostRequestDTO;
import br.ueg.acervodigital.dto.response.PostResponseDTO;
import br.ueg.acervodigital.entities.Post;
import br.ueg.acervodigital.mapper.PostMapper;
import br.ueg.acervodigital.service.IPostService;
import br.ueg.acervodigital.service.impl.PostService;
import br.ueg.genericarchitecture.controller.impl.AbstractCrudFileController;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("${api.version}/post")
public class PostController extends AbstractCrudFileController<
        PostRequestDTO, PostResponseDTO, PostListDTO, Post, PostService, PostMapper, Long>
        implements IPostController {

    @Autowired
    protected IPostService service;
    @Autowired
    protected PostMapper mapper;

    @GetMapping(path = "/list")
    public ResponseEntity<Page<PostListDTO>> listAllWithoutRole(Pageable pageable) {
        Page<PostListDTO> listDTO = this.service.listAllWithoutRole(pageable).map(obj -> mapper.toDTOList(obj));
        return ResponseEntity.ok(listDTO);
    }

    @GetMapping(path = {"view/{id}"})
    public ResponseEntity<PostResponseDTO> viewPost(@PathVariable Long id) {
        PostResponseDTO dtoResult = this.mapper.toDTO(this.service.getById(id));
        return ResponseEntity.ok(dtoResult);
    }

    @GetMapping(path = "/search/{tag}")
    @Operation(description = "End point para obter postagens por etiqueta")
    public ResponseEntity<Page<PostListDTO>> getPostByTag(
            @PathVariable("tag") String tag,
            Pageable pageable
    ) {
        Page<PostListDTO> modelList = this.service.getByTag(tag, pageable).map(obj -> mapper.toDTOList(obj));
        return ResponseEntity.of(
                Optional.ofNullable(modelList)
        );
    }
}
