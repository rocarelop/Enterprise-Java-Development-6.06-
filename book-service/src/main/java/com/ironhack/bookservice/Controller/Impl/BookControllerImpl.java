package com.ironhack.bookservice.Controller.Impl;

import com.ironhack.bookservice.Controller.Interfaces.BookController;
import com.ironhack.bookservice.DTO.BookDTO;
import com.ironhack.bookservice.Model.Book;
import com.ironhack.bookservice.Repository.BookRepository;
import com.ironhack.bookservice.client.BookFormatServiceClient;
import com.ironhack.bookservice.service.interfaces.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class BookControllerImpl implements BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookFormatServiceClient bookFormatServiceClient;
    @Autowired
    private BookService bookService;



    @GetMapping("/books/{ISBN}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBookInformation(@PathVariable(name = "ISBN") long ISBN) {

        return bookService.getBookInformation(ISBN);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBookFormat(@RequestBody @Valid Book book) {
        return bookRepository.save(book);
    }
}
