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
			repository.save(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997, "1234-5678", 19.99));
			repository.save(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1999, "9876-5432", 19.99));
			repository.save(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 2001, "1928-3746", 19.99));
			
			log.info("find books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}

