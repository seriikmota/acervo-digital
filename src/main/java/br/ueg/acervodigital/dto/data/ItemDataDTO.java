package br.ueg.acervodigital.dto.data;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDataDTO {
//TODO: remover atributos desnecessários a está visão
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

    private LocalDate heritage_date;
}