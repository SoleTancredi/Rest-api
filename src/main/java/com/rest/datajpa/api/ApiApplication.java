package com.rest.datajpa.api;

import com.rest.datajpa.api.entities.Book;
import com.rest.datajpa.api.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ApiApplication.class, args);
		ApplicationContext context = SpringApplication.run(ApiApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		//CRUD

		//crear libro
		Book book = new Book(null, "Home", "PepeAuthor", 500, 589.99, LocalDate.of(1997,07,20), true);
		Book book1 = new Book(null, "Little", "Rosa", 150, 79.99, LocalDate.of(2021,12,18), false);

		//almacenar
		repository.save(book);
		repository.save(book1);

		//recuperar
		System.out.println("Num libros en base de datos" + repository.findAll().size());

		//eliminar
		//repository.deleteById(1L);
		System.out.println("Libros que quedan" + repository.findAll().size());
	}


}
