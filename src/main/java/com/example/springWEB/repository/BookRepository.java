package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springWEB.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public Book save(Book book);
}
