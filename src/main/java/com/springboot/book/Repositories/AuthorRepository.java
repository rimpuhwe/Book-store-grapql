package com.springboot.book.Repositories;

import com.springboot.book.Entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

    AuthorEntity findByName(String name);
}