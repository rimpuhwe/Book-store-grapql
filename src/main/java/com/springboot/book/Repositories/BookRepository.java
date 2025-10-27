package com.springboot.book.Repositories;

import com.springboot.book.Entities.BookEntity;
import com.springboot.book.Records.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findBookEntityById(int id);

    BookEntity findBookEntityByBookName(String name);
}