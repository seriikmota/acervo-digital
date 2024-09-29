package br.ueg.acervodigital.dto.list;

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
public class ItemListDTO {
    private Long id;
    private User user;
    private String number_code;
    private String collector;
    private LocalDate colleaction_year;
    private String collection;
    private String provenance;
    private String location;
    private String period;
    private String register_date;
    private Integer status;
    private Integer approval;
    private String name;
    private String taxonomy;
    private LocalDate heritage_date;}
