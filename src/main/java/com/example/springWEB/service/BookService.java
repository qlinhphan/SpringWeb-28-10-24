package com.example.springWEB.service;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Book;
import com.example.springWEB.repository.BookRepository;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return this.bookRepository.save(book);
    }
}
