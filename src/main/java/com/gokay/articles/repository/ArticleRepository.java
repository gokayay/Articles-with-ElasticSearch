package com.gokay.articles.repository;

import com.gokay.articles.model.Article;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Override
    Optional<Article> findById(Long id);

    @Override
    List<Article> findAll(Sort sort);
}
