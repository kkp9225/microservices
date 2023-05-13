package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.AuthenticationRequest;
import com.security.exception.InvalidUserException;
import com.security.util.JwtUtils;

@RestController
public class UserInfoController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtils jwtUtils;
	
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<String> handleInvalidStockIdException(InvalidUserException invalidUserException) {
		return new ResponseEntity<String>("Local handler " + invalidUserException.toString(), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> authenticateRequest(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException badCredentialsException) {
			throw new InvalidUserException("Invalid username : " + authenticationRequest.getUsername() + "/ password: "
					+ authenticationRequest.getPassword());
		}
		String jwtToken = jwtUtils.generateToken(authenticationRequest.getUsername());
		return new ResponseEntity<String>(jwtToken, HttpStatus.OK);
	}

	@GetMapping("/all")
	public String viewAll() {
		return "Hello All";
	}

	@GetMapping("/user")
	public String viewUser() {
		return "Hello User";
	}

	@GetMapping("/admin")
	public String viewAdmin() {
		return "Hello Admin";
	}

}
