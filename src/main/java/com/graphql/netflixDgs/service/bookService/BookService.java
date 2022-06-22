package com.graphql.netflixDgs.service.bookService;

import com.graphql.netflixDgs.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> findById(String id);

    public List<Book> findAll();
}
