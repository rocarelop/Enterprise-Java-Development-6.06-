package com.ironhack.bookformatservice.Controller.Interfaces;

import com.ironhack.bookformatservice.model.BookFormat;

public interface BookFormatController {
    String getBookFormat(long ISBN);
    BookFormat postBookFormat(BookFormat bookFormat);
}