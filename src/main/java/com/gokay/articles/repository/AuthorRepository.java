package com.gokay.articles.repository;

import com.gokay.articles.model.Author;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Override
    Optional<Author> findById(Long id);

    @Override
    List<Author> findAll(Sort sort);
}
