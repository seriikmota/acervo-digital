package br.ueg.acervodigital.dto.request;

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
public class PostRequestDTO {
    private Long id;
    private String title;
    private String subtitle;
    private String content;
    private Boolean approval;
    private LocalDateTime publicationDate;
    private String tag;
    private List<ImageRequestDTO> images;
}
