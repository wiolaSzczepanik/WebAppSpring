package com.webApp.webApp.controller;

import com.webApp.webApp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){ // Model interface in Spring, spring will be passing Model obj in this method
        model.addAttribute("books", bookRepository.findAll());
        return "books"; // return the view name
    }
}
