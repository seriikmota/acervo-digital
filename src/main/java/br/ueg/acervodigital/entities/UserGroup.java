package br.ueg.acervodigital.entities;

import br.ueg.genericarchitecture.domain.GenericModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "users_group")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserGroup implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_group_role",
            joinColumns = @JoinColumn(name = "user_group_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private List<Role> roles;
}
