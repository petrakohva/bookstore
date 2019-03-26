package hh.swd20.bookstoremavenproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import hh.swd20.bookstoremavenproject.domain.Book;
import hh.swd20.bookstoremavenproject.domain.BookRepository;
import hh.swd20.bookstoremavenproject.domain.Genre;
import hh.swd20.bookstoremavenproject.domain.GenreRepository;
import hh.swd20.bookstoremavenproject.domain.User;
import hh.swd20.bookstoremavenproject.domain.UserRepository;

@SpringBootApplication
@ComponentScan
public class BookstoremavenprojectApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoremavenprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoremavenprojectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			log.info("save books");
			grepository.save(new Genre("Fantasy"));
			grepository.save(new Genre("Horror"));
			grepository.save(new Genre("Thriller"));
			
			
			brepository.save(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997, "1234-5678", 19.99, grepository.findByGenreName("Fantasy").get(0)));
			brepository.save(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1999, "9876-5432", 19.99, grepository.findByGenreName("Fantasy").get(0)));
			brepository.save(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 2001, "1928-3746", 19.99, grepository.findByGenreName("Fantasy").get(0)));
			
			User user1 = new User("user", "$2a$04$jd0qclLNkmgS.sYNNJn4N.TGm3d6hUqXVGdPKKXW3g.kwu5ClJWhu", "USER");
			User user2 = new User("admin", "$2a$04$uFdAKugLPJCS6sSkn.JnIuwqpibVV3Qffz53C31cTZz.tAXPloor6", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("find books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}

