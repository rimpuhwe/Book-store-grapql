package com.springboot.book.controllers;

import com.springboot.book.Records.Author;
import com.springboot.book.Records.AuthorInput;
import com.springboot.book.Services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;


    @MutationMapping
    public Author createNewAuthor(@Argument("input") AuthorInput input){
        return service.createNewAuthor(input);
    }
    @QueryMapping
    public List<Author> Authors(){
        return service.getAllAuthors();

    }
}
