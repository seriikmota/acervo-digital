package br.ueg.acervodigital.service.impl;

import br.ueg.acervodigital.dto.list.PostListDTO;
import br.ueg.acervodigital.dto.request.PostRequestDTO;
import br.ueg.acervodigital.dto.response.PostResponseDTO;
import br.ueg.acervodigital.entities.Post;
import br.ueg.acervodigital.entities.PostImage;
import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.mapper.PostMapper;
import br.ueg.acervodigital.repository.PostRepository;
import br.ueg.acervodigital.service.IPostService;
import br.ueg.genericarchitecture.dto.CredentialDTO;
import br.ueg.genericarchitecture.enums.ApiErrorEnum;
import br.ueg.genericarchitecture.exception.DataException;
import br.ueg.genericarchitecture.security.impl.CredentialProvider;
import br.ueg.genericarchitecture.service.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService extends AbstractService<PostRequestDTO, PostResponseDTO, PostListDTO, Post, PostRepository, PostMapper, Long>
        implements IPostService {

    @Autowired
    private PostRepository repository;

    @Override
    protected void prepareToCreate(Post data) {
        setUserAndPublicationDate(data);
    }

    @Override
    protected void prepareToUpdate(Post data) {
        setUserAndPublicationDate(data);
    }

    @Override
    protected void prepareToDelete(Post data) {
    }

    protected void setUserAndPublicationDate(Post data) {
        User user = new User();
        user.setId(((CredentialDTO) CredentialProvider.newInstance().getCurrentInstance()).getId());
        data.setUser(user);
        for (PostImage image : data.getImages()) {
            image.setPost(data);
        }
        data.setPublicationDate(LocalDateTime.now());
    }

    @Override
    public Page<Post> listAllWithoutRole(Pageable pageable) {
        return repository.findAllByApprovalTrue(pageable);
    }

    @Override
    public Page<Post> getByTag(String tag, Pageable pageable) {
        Page<Post> temp = repository.findByTagContaining(tag, pageable);
        if(temp.isEmpty()){
            throw new DataException(ApiErrorEnum.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return temp;
    }
}
