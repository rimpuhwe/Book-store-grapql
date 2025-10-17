package com.springboot.book.Entities;

import com.springboot.book.Records.AuthorInput;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;


    @NotEmpty
    @Column(nullable = false)
    private String bookName;


    @NotEmpty
    @Column(nullable = false)
    private String author;


    @Min(message = "the number of pages can not be negative", value = 0)
    @Column(nullable = false)
    private int pageCount;

}