package br.ueg.acervodigital.dto.list;

import br.ueg.acervodigital.entities.PostImages;
import br.ueg.acervodigital.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PostListDTO {
    private Long id;
    private User user;
    private String title;
    private String subtitle;
    private String content;
    private String approval;
    private LocalDateTime publication_date;
    private String tag;
    private List<PostImages> postImages;
}
