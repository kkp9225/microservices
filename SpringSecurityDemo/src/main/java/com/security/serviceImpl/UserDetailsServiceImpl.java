package com.security.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.security.entity.UserDetailsEntity;
import com.security.exception.InvalidUserException;
import com.security.repo.UserDetailsRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	@Override
	public UserDetails  loadUserByUsername(String username) throws InvalidUserException {
		UserDetailsEntity userDetailsEntity = new UserDetailsEntity(); 
		userDetailsEntity = userDetailsRepo.findUserByUsername(username);
		if(userDetailsEntity==null) {
			throw new InvalidUserException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(userDetailsEntity.getRole()));
		User user = new User(userDetailsEntity.getUsername(), userDetailsEntity.getPasword(), authorities);
		return user;
	}

}
