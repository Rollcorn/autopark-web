package com.project.autoparkweb.utill.Security;

import com.project.autoparkweb.mvc.model.dao.User;
import com.project.autoparkweb.mvc.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userRepository.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User with name [" + username + "] not found");
		}
		return new UserDetailsImp(user);
	}
}
