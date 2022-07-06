package com.ironhack.bookservice.Controller.Interfaces;

import com.ironhack.bookservice.DTO.BookDTO;
import com.ironhack.bookservice.Model.Book;

public interface BookController {
    BookDTO getBookInformation(long ISBN);
    Book postBookFormat(Book book);
}
