package com.ironhack.bookformatservice.Controller.impl;

import com.ironhack.bookformatservice.Controller.Interfaces.BookFormatController;
import com.ironhack.bookformatservice.Repository.BookFormatRepository;
import com.ironhack.bookformatservice.model.BookFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class BookFormatControllerImpl implements BookFormatController {
    @Autowired
    private BookFormatRepository bookFormatRepository;
    @GetMapping("/book-formats/{ISBN}")
    @ResponseStatus(HttpStatus.OK)
    public String getBookFormat(@PathVariable(name = "ISBN") long ISBN) {
        Optional<BookFormat> bookFormat = bookFormatRepository.findById(ISBN);
        return bookFormat.get().getFormat().toString();
    }

    @PostMapping("/book-formats")
    @ResponseStatus(HttpStatus.CREATED)
    public BookFormat postBookFormat(@RequestBody @Valid BookFormat bookFormat) {
        return bookFormatRepository.save(bookFormat);
    }
}