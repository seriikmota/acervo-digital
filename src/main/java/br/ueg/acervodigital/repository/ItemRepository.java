package br.ueg.acervodigital.repository;

import br.ueg.acervodigital.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByNumberCode(String numberCode);

    Page<Item> findAllByApprovalTrue(Pageable pageable);

    @Query("select i from Item i where upper(i.name) like upper(concat('%',:name,'%')) and i.approval = true")
    Page<Item> findByNameContaining(@Param("name") String name, Pageable pageable);

    @Query("select i from Item i where upper(i.description) like upper(concat('%',:description,'%'))")
    List<Item> findByDescriptionContaining(@Param("description") String description);

    @Query("select i from Item i where upper(i.description) like upper(concat('%',:text,'%')) or upper(i.name) like upper(concat('%',:text,'%'))")
    List<Item> findByDescriptionOrNameContaining(@Param("text") String text);

    @Query("select i from Item i where upper(i.collection) like upper(concat('%',:collection,'%'))")
    List<Item> findByCollectionContaining(@Param("collection") String collection);

    @Query("select i from Item i where upper(i.provenance) like upper(concat('%',:provenance,'%'))")
    List<Item> findByProvenanceContaining(@Param("provenance") String provenance);
}
