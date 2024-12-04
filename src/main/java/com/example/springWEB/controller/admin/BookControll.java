package com.example.springWEB.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springWEB.domain.Book;
import com.example.springWEB.service.BookService;

@Controller
public class BookControll {

    private BookService bookService;

    public BookControll(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/admin/book")
    public String book(Model model) {
        return "/admin/TableBook";
    }

    @GetMapping("/admin/book/create")
    public String cBook(Model model, @ModelAttribute("newBook") Book book) {
        return "/admin/CreateBook";
    }

    @PostMapping("/createBook/ok")
    public String createOk(Model model, @ModelAttribute("newBook") Book book) {
        Book bookDif = new Book();
        bookDif.setName(book.getName());
        bookDif.setPublisher(book.getPublisher());
        bookDif.setYear(book.getYear());
        bookDif.setShortDes(book.getShortDes());
        bookDif.setDetailDes(book.getDetailDes());
        this.bookService.saveBook(bookDif);
        return "ok";
    }

}
