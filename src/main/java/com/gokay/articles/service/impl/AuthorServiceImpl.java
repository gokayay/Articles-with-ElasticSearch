package com.gokay.articles.service.impl;

import com.gokay.articles.exception.ObjectNotFoundException;
import com.gokay.articles.model.Author;
import com.gokay.articles.repository.AuthorRepository;
import com.gokay.articles.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Long id, Author author) {
        Optional<Author> existedAuthor = authorRepository.findById(id);

        if (!existedAuthor.isPresent())
            throw new ObjectNotFoundException("Author not found");

        Author exAuthor = existedAuthor.get();
        exAuthor.setAuthorName(author.getAuthorName());
        exAuthor.setArticles(author.getArticles());

        authorRepository.save(exAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> getOneAuthor(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
