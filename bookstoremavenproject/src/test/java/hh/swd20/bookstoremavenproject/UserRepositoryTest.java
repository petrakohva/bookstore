package hh.swd20.bookstoremavenproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import hh.swd20.bookstoremavenproject.domain.User;
import hh.swd20.bookstoremavenproject.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;

	
	@Test
	public void findByUsernameShouldReturnUser() {
		List<User> users = urepository.findByUsername("admin");
		
		assertThat(users).hasSize(1);
		
		
	}
	
	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$04$jd0qclLNkmgS.sYNNJn4N.TGm3d6hUqXVGdPKKXW3g.kwu5ClJWhu", "USER");
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
	}

}
