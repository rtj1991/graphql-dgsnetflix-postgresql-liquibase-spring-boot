package com.graphql.netflixDgs.service.bookService;

import com.graphql.netflixDgs.model.Book;
import com.graphql.netflixDgs.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findById(String id) {
        return bookRepository.findAllById(Collections.singleton(Integer.valueOf(id)));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
