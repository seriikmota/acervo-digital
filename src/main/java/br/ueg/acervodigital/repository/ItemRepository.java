package br.ueg.acervodigital.repository;

import br.ueg.acervodigital.entities.Item;
import br.ueg.acervodigital.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
