package com.springboot.book.controllers;

import com.springboot.book.Records.Book;
import com.springboot.book.Records.CreateBookInput;
import com.springboot.book.Records.UpdateBookInput;
import com.springboot.book.Services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookController {
    private final BookService service;

    @MutationMapping("createNewBook")
    public Book createNewBook(@Argument("input") CreateBookInput book){
        return service.createBook(book);
    }

    @QueryMapping
    public List<Book> Books(){

        return service.getAllBooks();
    }
    @MutationMapping("updateBook")
    public Book updateBook(@Argument("input") UpdateBookInput book){
        return service.updateBook(book);
    }
    @MutationMapping("deleteBook")
    public Boolean deleteBook(@Argument String name){
        return  service.deleteBook(name);
    }

}
