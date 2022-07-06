package com.ironhack.bookservice.service.interfaces;

import com.ironhack.bookservice.DTO.BookDTO;
import com.ironhack.bookservice.Model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface BookService {
    BookDTO getBookInformation(long ISBN);
}
