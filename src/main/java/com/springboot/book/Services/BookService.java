package com.springboot.book.Services;

import com.springboot.book.Entities.BookEntity;
import com.springboot.book.Records.Book;
import com.springboot.book.Records.CreateBookInput;
import com.springboot.book.Repositories.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BookService {
    private BookRepository repository;

    public Book createBook(CreateBookInput book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(book.name());
        bookEntity.setAuthor(book.author());
        bookEntity.setPageCount(book.pageCount());
        repository.save(bookEntity);
        return new Book(bookEntity.getBookName(), bookEntity.getAuthor(), bookEntity.getPageCount());
    }
    public List<Book> getAllBooks() {
        return  repository.findAll()
                           .stream()
                           .map(entity -> new Book(entity.getBookName(), entity.getAuthor(), entity.getPageCount()))
                           .collect(Collectors.toList());
    }




}
