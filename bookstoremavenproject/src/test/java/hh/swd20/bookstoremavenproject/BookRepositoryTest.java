package hh.swd20.bookstoremavenproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstoremavenproject.domain.Book;
import hh.swd20.bookstoremavenproject.domain.BookRepository;
import hh.swd20.bookstoremavenproject.domain.Genre;
import hh.swd20.bookstoremavenproject.domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository brepository;

	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = brepository.findByTitle("Harry Potter and the Philosopher's Stone");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("J. K. Rowling");
		
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling", 2003, "6532-8946", 19.99, new Genre("Fiction"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	


}
