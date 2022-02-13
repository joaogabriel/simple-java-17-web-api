package com.joaotech.simplejava17webapi.controller;

import com.joaotech.simplejava17webapi.dto.BookDTO;
import com.joaotech.simplejava17webapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        List<BookDTO> books = bookService.findAll();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> search(@RequestParam String title) {
        List<BookDTO> books = bookService.findByTitle(title);
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/rating-order")
    public ResponseEntity<List<BookDTO>> findRatingWithOrder() {
        List<BookDTO> books = bookService.findByBestRating();
        return ResponseEntity.ok().body(books);
    }

}
