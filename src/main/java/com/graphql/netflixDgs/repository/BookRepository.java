package com.graphql.netflixDgs.repository;

import com.graphql.netflixDgs.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
