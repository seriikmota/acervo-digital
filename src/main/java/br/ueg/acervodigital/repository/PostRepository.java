package br.ueg.acervodigital.repository;

import br.ueg.acervodigital.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long Id);

    Page<Post> findAllByApprovalTrue(Pageable pageable);

    @Query("select p from Post p where upper(p.tag) like upper(concat('%',:tag,'%')) and p.approval")
    Page<Post> findByTagContaining(@Param("tag") String tag, Pageable pageable);

    @Query("select p from Post p where upper(p.title) like upper(concat('%',:title,'%'))")
    List<Post> findByTitleContaining(@Param("title") String title);

    @Query("select p from Post p where upper(p.subtitle) like upper(concat('%',:subtitle,'%'))")
    List<Post> findBySubtitleContaining(@Param("subtitle") String subtitle);
}
