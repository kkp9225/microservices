package com.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.security.entity.UserDetailsEntity;

@Service
public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity, Integer>{

	@Query("SELECT u FROM UserDetailsEntity u WHERE u.username=?1")
	UserDetailsEntity findUserByUsername(String username);

}
