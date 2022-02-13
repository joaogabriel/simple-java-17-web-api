package com.joaotech.simplejava17webapi.adapter;

import com.joaotech.simplejava17webapi.dto.BookDTO;
import com.joaotech.simplejava17webapi.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookAdapter {

    public static List<BookDTO> convert(List<Book> books) {
        return books.stream()
                .map(BookAdapter::convert)
                .collect(Collectors.toList());
    }

    public static BookDTO convert(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getRating());
    }

}
