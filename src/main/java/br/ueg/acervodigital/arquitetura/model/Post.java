package br.ueg.acervodigital.arquitetura.model;

import br.ueg.acervodigitalarquitetura.domain.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post implements BaseModel<Long> {
    public final static String SEQUENCE_NAME = "post_sequence";

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

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "content")
    private String content;

    @Column(name = "approval")
    private String approval;

    @Column(name = "publication_date")
    private LocalDateTime publication_date;

    @Column(name = "tag")
    private String tag;
}
