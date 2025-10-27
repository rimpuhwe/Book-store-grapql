package com.springboot.book.Records;

public record CreateBookInput(String name, int pageCount, AuthorInput author) {
}
