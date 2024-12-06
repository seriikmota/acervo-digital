package br.ueg.acervodigital.repository;

import br.ueg.acervodigital.entities.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    UserGroup findByName(String name);
}
