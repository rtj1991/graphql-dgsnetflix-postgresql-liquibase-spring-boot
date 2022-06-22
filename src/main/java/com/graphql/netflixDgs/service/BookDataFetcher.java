package com.graphql.netflixDgs.service;

import com.graphql.netflixDgs.model.Book;
import com.graphql.netflixDgs.service.bookService.BookService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class BookDataFetcher {
    @Autowired
    private BookService bookService;

    @DgsData(parentType = "Query",field = "allBooks")
    public List<Book> getBooks(@InputArgument("id") String id){
        if (id == null) {
            return bookService.findAll();
        }
        return bookService.findById(id);
    }
}
