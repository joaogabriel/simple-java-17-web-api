package com.joaotech.simplejava17webapi.service;

import com.joaotech.simplejava17webapi.adapter.BookAdapter;
import com.joaotech.simplejava17webapi.dto.BookDTO;
import com.joaotech.simplejava17webapi.model.Book;
import com.joaotech.simplejava17webapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final EntityManager entityManager;

    public BookServiceImpl(BookRepository bookRepository, EntityManager entityManager) {
        this.bookRepository = bookRepository;
        this.entityManager = entityManager;
    }

    public List<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        return BookAdapter.convert(books);
    }

    public List<BookDTO> findByTitle(String title) {
        String hql = "SELECT book " +
                "FROM Book book " +
                "WHERE UPPER(book.title) LIKE UPPER(:title)";
        Query query = entityManager.createQuery(hql);
        query.setParameter("title", "%" + title + "%");
        List<Book> books = query.getResultList();
        return BookAdapter.convert(books);
    }

    @Override
    public List<BookDTO> findByBestRating() {
        String hql = "SELECT book " +
                "FROM Book book " +
                "ORDER BY book.rating DESC ";
        Query query = entityManager.createQuery(hql);
        List<Book> books = query.getResultList();
        return BookAdapter.convert(books);
    }

}
