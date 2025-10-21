package com.springboot.book.Services;

import com.springboot.book.Entities.BookEntity;
import com.springboot.book.Records.Book;
import com.springboot.book.Records.CreateBookInput;
import com.springboot.book.Records.UpdateBookInput;
import com.springboot.book.Repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class BookService {
    private final BookRepository repository;

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
    public Book updateBook(UpdateBookInput book) {
      BookEntity  book1 = repository.findBookEntityById(book.id());
      if (book1 != null) {
          book1.setBookName(book.name());
          book1.setAuthor(book.author());
          book1.setPageCount(book.pageCount());
      }
      else{
          throw new RuntimeException("Book not found");
      }
      repository.save(book1);
      return new Book(book1.getBookName(), book1.getAuthor(), book1.getPageCount());

    }
    public boolean deleteBook(String name) {

        BookEntity deleted = repository.findBookEntityByBookName(name);
        if (deleted != null) {
            repository.delete(deleted);
        }
        else {
            throw new IllegalArgumentException("Book with name " + name+ " not found");
        }
        return true;

    }




}
