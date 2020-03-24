package com.gokay.articles.controller;

import com.gokay.articles.model.Author;
import com.gokay.articles.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
    AuthorService authorService;

    // GET

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Author>> findAllAuthors() {

        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findOneAirport(@PathVariable Long id) {

        return new ResponseEntity(authorService.getOneAuthor(id), HttpStatus.OK);
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Author author) {
        authorService.createAuthor(author);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody  Author author){
        authorService.updateAuthor(id,author);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}
