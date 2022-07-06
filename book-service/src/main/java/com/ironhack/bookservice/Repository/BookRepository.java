package com.ironhack.bookservice.Repository;

import com.ironhack.bookservice.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
