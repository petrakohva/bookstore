package hh.swd20.bookstoremavenproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstoremavenproject.domain.Book;
import hh.swd20.bookstoremavenproject.domain.BookRepository;

@SpringBootApplication
public class BookstoremavenprojectApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoremavenprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoremavenprojectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save books");
			repository.save(new Book("Harry Potter and the Philosophers Stone", "J. K. Rowling", 1997, "a13j533", 19.99));
			repository.save(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1999, "bh7362k", 19.99));
			
			log.info("find books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}

