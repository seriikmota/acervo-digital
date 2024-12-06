package br.ueg.acervodigital.repository;

import br.ueg.acervodigital.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
