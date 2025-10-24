package com.springboot.book.Services;


import com.springboot.book.Entities.AuthorEntity;
import com.springboot.book.Entities.BookEntity;
import com.springboot.book.Records.Author;
import com.springboot.book.Records.AuthorInput;
import com.springboot.book.Records.Book;
import com.springboot.book.Records.CreateBookInput;
import com.springboot.book.Repositories.AuthorRepository;
import com.springboot.book.Repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Book createBook(int id,CreateBookInput input) {
        AuthorEntity author  = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        BookEntity book = new BookEntity();
        if (author != null) {
            book.setAuthor(author);
            book.setBookName(input.name());
            book.setPageCount(input.pageCount());
            bookRepository.save(book);
        }

        assert author != null;
        return new Book(book.getBookName(),new Author(author.getName(),author.getEmail(),null), book.getPageCount());

    }

    public List<Book> getAllBook() {
        return  bookRepository.findAll().stream()
                                         .map(book -> new Book(book.getBookName(),new Author(book.getAuthor().getName(),book.getAuthor().getEmail(), Collections.emptyList()) , book.getPageCount()))
                                         .collect(Collectors.toList());
    }


}
