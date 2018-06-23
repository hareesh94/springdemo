package com.example.springdemo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.springdemo.model.Author;
import com.example.springdemo.model.Book;
import com.example.springdemo.model.Publisher;
import com.example.springdemo.repositories.AuthorRepository;
import com.example.springdemo.repositories.BookRepository;
import com.example.springdemo.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PublisherRepository publisherRepository;
	
	

	private void initData(){
		Author Har = new Author("Har", "Nut");
		Publisher pub1 = new Publisher("Own", "351 SW");
		Book aaa = new Book("Spring", "1234", pub1);
		Har.getBook().add(aaa);
		aaa.getAuthors().add(Har);
		publisherRepository.save(pub1);

		authorRepository.save(Har);
		bookRepository.save(aaa);
		
		Author Kal = new Author("Kal", "Tn");
		Publisher pub2 = new Publisher("Oneil", "326 NE");
		Book bbb = new Book("Env", "1248", pub2);
		Kal.getBook().add(bbb);
		bbb.getAuthors().add(Kal);
		publisherRepository.save(pub2);
		authorRepository.save(Kal);
		bookRepository.save(bbb);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
}
