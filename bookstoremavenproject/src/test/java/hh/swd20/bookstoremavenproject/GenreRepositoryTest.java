package hh.swd20.bookstoremavenproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import hh.swd20.bookstoremavenproject.domain.Genre;
import hh.swd20.bookstoremavenproject.domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GenreRepositoryTest {
	
	@Autowired
	private GenreRepository grepository;

	
	@Test
	public void findByGenreNameShouldReturnGenre() {
		List<Genre> genres = grepository.findByGenreName("Horror");
		
		assertThat(genres).hasSize(1);
		
		
	}
	
	@Test
	public void createNewGenre() {
		Genre genre = new Genre("Romance");
		grepository.save(genre);
		assertThat(genre.getGenreid()).isNotNull();
	}

}
