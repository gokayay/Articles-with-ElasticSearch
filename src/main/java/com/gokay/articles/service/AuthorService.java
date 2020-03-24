package com.gokay.articles.service;

import com.gokay.articles.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    void createAuthor(Author author);

    void updateAuthor(Long id, Author author);

    void deleteAuthor(Long id);

    Optional<Author> getOneAuthor(Long id);

    List<Author> getAllAuthors();
}
