package com.example.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springdemo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
