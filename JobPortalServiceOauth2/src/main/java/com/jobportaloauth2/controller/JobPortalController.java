package com.jobportaloauth2.controller;

import java.security.Principal;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobPortalController {
	
	@GetMapping(value="/")
	public String getMessage(Principal principal) {
		OAuth2AuthenticationToken auth2AuthenticationToken = (OAuth2AuthenticationToken) principal;
		String loginName = auth2AuthenticationToken.getPrincipal().getAttribute("login");
		return "Hello " + loginName + "! How are you!?";
	}

}
