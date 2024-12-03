package br.ueg.acervodigital.service;

import br.ueg.acervodigital.dto.request.PostRequestDTO;
import br.ueg.acervodigital.entities.Post;
import br.ueg.genericarchitecture.service.IAbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService extends IAbstractService<PostRequestDTO, Post, Long> {
    Page<Post> listAllWithoutRole(Pageable pageable);
    Page<Post> getByTag(String tag, Pageable pageable);
}
