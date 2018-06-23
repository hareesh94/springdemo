package com.example.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springdemo.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
