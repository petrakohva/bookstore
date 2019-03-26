package hh.swd20.bookstoremavenproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.swd20.bookstoremavenproject.domain.User;
import hh.swd20.bookstoremavenproject.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository repository;

	
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
	this.repository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		List<User> curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, ((User) curruser).getPasswordHash(),
				AuthorityUtils.createAuthorityList(((User) curruser).getRole()));
		return user;
	}


}
