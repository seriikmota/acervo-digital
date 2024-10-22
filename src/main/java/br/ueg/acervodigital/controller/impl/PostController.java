package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.controller.IPostController;
import br.ueg.acervodigital.dto.list.PostListDTO;
import br.ueg.acervodigital.dto.request.PostRequestDTO;
import br.ueg.acervodigital.dto.response.PostResponseDTO;
import br.ueg.acervodigital.mapper.PostMapper;
import br.ueg.acervodigital.service.impl.PostService;
import br.ueg.acervodigitalarquitetura.controller.impl.AbstractCrudController;
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
@RequestMapping("${api.version}/post")
public class PostController extends AbstractCrudController<PostRequestDTO, PostResponseDTO, PostListDTO, PostService, Long>
        implements IPostController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected PostService service;
    @Autowired
    protected PostMapper mapper;

    @GetMapping(path = "/post-search/{tag}")
    @Operation(description = "End point para obter postagens por etiqueta")
    public ResponseEntity<List<PostListDTO>> getPostByTag(
            @PathVariable("tag") String tag
    ) {
        List<PostListDTO> modelList = mapper.fromModelToDTOList(service.getByTag(tag));
        return ResponseEntity.of(
                Optional.ofNullable(modelList)
        );
    }
}
