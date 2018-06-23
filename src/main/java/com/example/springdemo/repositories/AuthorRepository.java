package com.example.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springdemo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
