package com.gokay.articles.service.impl;

import com.gokay.articles.exception.ObjectNotFoundException;
import com.gokay.articles.model.Article;
import com.gokay.articles.repository.ArticleRepository;
import com.gokay.articles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void createArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void updateArticle(Long id, Article article) {
        Optional<Article> existedArticle = articleRepository.findById(id);

        if (!existedArticle.isPresent())
            throw new ObjectNotFoundException("Article not found");

        Article exArticle = existedArticle.get();
        exArticle.setTitle(article.getTitle());
        exArticle.setContent(article.getContent());
        exArticle.setDate(article.getDate());
        exArticle.setClap(article.getClap());
        exArticle.setAuthor(article.getAuthor());

        articleRepository.save(exArticle);

    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Optional<Article> getOneArticle(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
