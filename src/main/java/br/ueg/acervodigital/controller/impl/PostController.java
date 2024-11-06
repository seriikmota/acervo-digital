package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.controller.IPostController;
import br.ueg.acervodigital.dto.list.PostListDTO;
import br.ueg.acervodigital.dto.request.ImageRequestDTO;
import br.ueg.acervodigital.dto.request.PostRequestDTO;
import br.ueg.acervodigital.dto.response.PostResponseDTO;
import br.ueg.acervodigital.mapper.PostMapper;
import br.ueg.acervodigital.service.impl.PostService;
import br.ueg.acervodigitalarquitetura.controller.impl.AbstractCrudController;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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

    @PostMapping("/add")
    @Transactional
    @PreAuthorize("hasRole(#root.this.getRoleName('CREATE'))")
    public ResponseEntity<PostResponseDTO> addPost(
            @RequestPart("dto") PostRequestDTO dto,
            @RequestPart("images") List<MultipartFile> images) throws IOException {

        List<ImageRequestDTO> listImageDTO = new ArrayList<>();
        for (MultipartFile image : images) {
            ImageRequestDTO imageDTO = ImageRequestDTO.builder()
                    .image(image.getBytes())
                    .build();
            listImageDTO.add(imageDTO);
        }
        dto.setImages(listImageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

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
