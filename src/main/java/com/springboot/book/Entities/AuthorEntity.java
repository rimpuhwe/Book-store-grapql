package com.springboot.book.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Email(message = "the email must be valid")
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    private List<BookEntity> books = new ArrayList<>();

}