package br.ueg.acervodigital.dto.response;

import br.ueg.acervodigital.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {
    private Long id;
    private User user;
    private String numberCode;
    private String collector;
    private LocalDate colleactionYear;
    private String collection;
    private String provenance;
    private String location;
    private String period;
    private String registerDate;
    private Integer status;
    private Integer approval;
    private String name;
    private String taxonomy;
    private LocalDate heritageDate;
}
