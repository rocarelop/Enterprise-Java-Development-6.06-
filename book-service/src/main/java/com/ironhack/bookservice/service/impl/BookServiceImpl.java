package com.ironhack.bookservice.service.impl;

import com.ironhack.bookservice.Controller.Impl.BookControllerImpl;
import com.ironhack.bookservice.DTO.BookDTO;
import com.ironhack.bookservice.Model.Book;
import com.ironhack.bookservice.Repository.BookRepository;
import com.ironhack.bookservice.client.BookFormatServiceClient;
import com.ironhack.bookservice.service.interfaces.BookService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookFormatServiceClient bookFormatServiceClient;

    private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @CircuitBreaker(name="getBookInformation", fallbackMethod = "getBookInformationFallBack")
    public BookDTO getBookInformation(@PathVariable(name = "ISBN") long ISBN) {

        Optional<Book> bookOptional = bookRepository.findById(ISBN);
        if (!bookOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        String bookFormat = bookFormatServiceClient.getBookFormat(ISBN);
        BookDTO bookDTO = new BookDTO(ISBN, bookOptional.get().getTitle(), bookOptional.get().getAuthor(),
                bookOptional.get().getGenre(), bookFormat);

        return bookDTO;
    }

    public BookDTO getBookInformationFallBack(@PathVariable(name = "ISBN") long ISBN, Exception e) throws Exception {
        logger.error(e.getMessage());
        throw new Exception("ERROR");
    }
}
