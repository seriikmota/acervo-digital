package br.ueg.acervodigital.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDTO {
    private Long id;
    private String numberCode;
    private String collector;
    private LocalDate colleactionYear;
    private String collection;
    private String provenance;
    private String location;
    private String period;
    private LocalDate registerDate;
    private Integer status;
    private Integer approval;
    private String name;
    private String taxonomy;
    private LocalDate heritageDate;
}
