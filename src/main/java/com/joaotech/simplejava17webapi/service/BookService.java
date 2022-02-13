package com.joaotech.simplejava17webapi.service;

import com.joaotech.simplejava17webapi.dto.BookDTO;

import java.util.List;

public sealed interface BookService permits BookServiceImpl {

    List<BookDTO> findAll();

    List<BookDTO> findByTitle(String title);

    List<BookDTO> findByBestRating();

}
