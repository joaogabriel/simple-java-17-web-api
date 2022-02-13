package com.joaotech.simplejava17webapi.dto;

public class BookDTO {

    private final Long id;
    private final String title;
    private final String author;
    private final Double rating;

    public BookDTO(Long id, String title, String author, Double rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getRating() {
        return rating;
    }

}
