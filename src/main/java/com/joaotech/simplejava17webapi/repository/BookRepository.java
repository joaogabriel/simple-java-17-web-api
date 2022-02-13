package com.joaotech.simplejava17webapi.repository;

import com.joaotech.simplejava17webapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
