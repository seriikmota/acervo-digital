package br.ueg.acervodigital.entities;

import br.ueg.acervodigitalarquitetura.domain.GenericModel;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class Item implements GenericModel<Long> {
    public final static String SEQUENCE_NAME = "item_sequence";

    @Id
    @SequenceGenerator(
            name=SEQUENCE_NAME,
            sequenceName = SEQUENCE_NAME + "_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = SEQUENCE_NAME
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_id"))
    private User user;

    @Column(name = "number_code")
    private String number_code;

    @Column(name = "collector")
    private String collector;

    @Column(name = "colleaction_year")
    private LocalDate colleaction_year;

    @Column(name = "collection")
    private String collection;

    @Column(name = "provenance")
    private String provenance;

    @Column(name = "location")
    private String location;

    @Column(name = "period")
    private String period;

    @Column(name = "register_date")
    private String register_date;

    @Column(name = "status")
    private Integer status;

    @Column(name = "approval")
    private Integer approval;

    @Column(name = "name")
    private String name;

    @Column(name = "taxonomy")
    private String taxonomy;

    @Column(name = "heritage_date")
    private LocalDate heritage_date;
}