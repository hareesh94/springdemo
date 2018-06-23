package com.example.springdemo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.springdemo.model.Author;
import com.example.springdemo.model.Book;
import com.example.springdemo.repositories.AuthorRepository;
import com.example.springdemo.repositories.BookRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	private void initData(){
		Author Har = new Author("Har", "Nut");
		Book aaa = new Book("Spring", "1234", "own");
		Har.getBook().add(aaa);
		aaa.getAuthors().add(Har);
		authorRepository.save(Har);
		bookRepository.save(aaa);
		
		Author Kal = new Author("Kal", "Tn");
		Book bbb = new Book("Env", "1248", "Oneil");
		Kal.getBook().add(bbb);
		bbb.getAuthors().add(Kal);
		authorRepository.save(Kal);
		bookRepository.save(bbb);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
}
