/*
 * package com.olxadvertise.serviceImpl;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.cloud.client.loadbalancer.LoadBalanced; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.http.HttpEntity; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.http.MediaType; import
 * org.springframework.stereotype.Service; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.olxadvertise.service.UserServiceDelegate;
 * 
 * //@Service public class UserDelegateServiceImpl implements
 * UserServiceDelegate {
 * 
 * @Autowired RestTemplate restTemplate;
 * 
 * 
 * @Bean
 * 
 * @LoadBalanced public RestTemplate getRestTemplate() { return new
 * RestTemplate(); }
 * 
 * 
 * @Override public Boolean isValidUser(String auth_token) { HttpHeaders headers
 * = new HttpHeaders(); headers.add("Authorization", auth_token);
 * headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
 * HttpEntity<String> entity = new HttpEntity<>(headers); return
 * restTemplate.exchange("http://l/token/validate", HttpMethod.GET, entity,
 * Boolean.class) .getBody(); }
 * 
 * }
 */