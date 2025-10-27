package com.springboot.book.Records;

import java.util.List;

public record Author(String name,String email, List<Book> books) {
}
