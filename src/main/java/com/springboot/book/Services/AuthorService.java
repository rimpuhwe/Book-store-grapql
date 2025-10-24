package com.springboot.book.Services;

import com.springboot.book.Entities.AuthorEntity;
import com.springboot.book.Records.Author;
import com.springboot.book.Records.AuthorInput;
import com.springboot.book.Records.Book;
import com.springboot.book.Repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author createNewAuthor(AuthorInput author) {
        AuthorEntity newAuthor =  new AuthorEntity();
        newAuthor.setName(author.name());
        newAuthor.setEmail(author.email());

        authorRepository.save(newAuthor);

        return  new Author(newAuthor.getName(), newAuthor.getEmail(), Collections.emptyList() );

    }
    public List<Author> getAllAuthors(){
        return  authorRepository.findAll().stream()
                                          .map(
                                                  author -> new Author(
                                                          author.getName(),
                                                          author.getEmail(),
                                                          author.getBooks().stream()
                                                                           .map(book -> new Book(
                                                                                   book.getBookName(),
                                                                                   null,
                                                                                   book.getPageCount()
                                                                                   )
                                                                           ).collect(Collectors.toList())))
                                          .collect(Collectors.toList());
    }
}
