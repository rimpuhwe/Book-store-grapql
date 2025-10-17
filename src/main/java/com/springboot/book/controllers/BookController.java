package com.springboot.book.controllers;

import com.springboot.book.Records.Book;
import com.springboot.book.Records.CreateBookInput;
import com.springboot.book.Services.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class BookController {
    private BookService service;

    @MutationMapping("createNewBook")
    public Book createNewBook(@Argument("input") CreateBookInput book){
        return service.createBook(book);
    }

    @QueryMapping
    public List<Book> Books(){
        return service.getAllBooks();
    }
}
