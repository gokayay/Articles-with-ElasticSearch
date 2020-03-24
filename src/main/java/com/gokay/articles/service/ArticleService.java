package com.gokay.articles.service;

import com.gokay.articles.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    void createArticle(Article article);

    void updateArticle(Long id, Article article);

    void deleteArticle(Long id);

    Optional<Article> getOneArticle(Long id);

    List<Article> getAllArticles();
}
