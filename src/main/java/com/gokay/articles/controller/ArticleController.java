package com.gokay.articles.controller;

import com.gokay.articles.model.Article;
import com.gokay.articles.model.Author;
import com.gokay.articles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    // GET

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Article>> findAllArticles() {

        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findOneAirport(@PathVariable Long id) {

        return new ResponseEntity(articleService.getOneArticle(id), HttpStatus.OK);
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Article article) {
        articleService.createArticle(article);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody  Article article){
        articleService.updateArticle(id,article);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}
