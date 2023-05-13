# microservices
Java Microservices Day 4 by Anand Kulkarni - Stock project with simple controller with Lombok
Java Microservices Day 5 by Anand Kulkarni - olx advertisement project creation
Java Microservices Day 6 by Anand Kulkarni - Swagger for Rest API documentation and replace Postman
	- http://localhost:portno/swagger-ui/
	- Swagger UI is rendered through Docket object - so we will have to configure/edit the Docket object to custom Swagger UI in main application
	class and override the Docket class and APIInfo class
	
Java Microservices Day 7 by Anand Kulkarni - Thymeleaf, Actuator - SpringBootDemo application
	- Acutator helps us monitor the health of our application 
	- management.endpoints.web.exposure.include=* to display all endpoints 
	- management.endpoints.web.exposure.include=health,bean,env to display specific endpoints
	- management:
  endpoint:
    shutdown:
      enabled: true
  endpoints:
    web:
      base-path: /olx-monitor
      exposure:
        include: '*'
		
Java Microservices Day 8 by Anand Kulkarni - Spring data(JPA), Custom Exception handling, Entity relationship	
	- creating customExceptionClass - @ResponseStatus(HttpStatus.BAD_REQUEST) to specify type of return
	
Java Microservices Day 9 by Anand Kulkarni - Entity relationship continued, MongoDb repository 
	- impl of Mongdb repo along with JPA repo and configuring services with @Qualifier
	- RestTemplate impl
	
Java Microservices Day 10 by Anand Kulkarni	- Spring Security
	- What we do with Spring Security?

	1) Username/password authentication - 
		- Authentication - who are you?
			2 types - KBA(Username/password) and PBA(OTP) 
		- Authorization - are you allowed to access the particular api?
		- Principle 
			The process to verify the logged in person and is currently logged in user
		- Granted Authority 
			User is authorized to perform actions
		- Roles
			The user is has roles and based on roles he has authority
		
		- Authentication Manager is the heart of the Spring security
		
	2) SSO/Okta/LDAP

	3) Application level Authorization

	4) Intra App Authorization like OAuth

	5) Microservice level security (using tokens, JWT)
	
	6) Method level security
	
Java Microservices Day 11 by Anand Kulkarni	- JWT token
	- What is JWT - Json Web token
	- Is used to authorize user login 
	- is sent in Header of each api - Autherization Bearer <token>
	- SSO apps can use JWT
		AWDW.FAFWR84FDF.NJKAI56
		Header - AWDW - 
		Payload - FAFWR84FDF
		Signature - NJKAI56	

Java Microservices Day 12 by Anand Kulkarni - advertisement / login and / master data using OAuth

	- Open Authorization used to authorization between two microservices 
	- Authorization servers which help the app to acess the resource servers 
		- Keycloak
		- Okta
	- Discovery service to register all microservices	 
	
Java Microservices Day 13 by Anand Kulkarni	- Config service and Circuit breaker
	- Config service is used to configure all microservice configuration like db connections in it.
		- create .yml files of all microservices along with configurations and store them in repository
		- everytime config server starts its going to pull the .yml files from repo. Once the microservices start they are going
			to communicate with config server and get those .yml file congigurations loaded.
	- Circuit breaker is specific to the particular to call, means every api call will have seperate circuit breaker
		- configured in client applications
		- states : CLOSED - happy path, so all apis working fine
			   : HALF_OPEN - not sure whether apis are working fine till 10 calls
			   : OPEN - when api calls do not respond after 10 calls
		- Resilience API for circuit breaker implementation

Java Microservices Day 14 by Anand Kulkarni	- Circuit breaker continuation, API Gateway, Zipkin and Sluith
	- Circuit breaker - Using @CircuitBreaker(name="",fallbackmethod="") annotation on the services which make another api call
	- 	              - add configurations in app.yml file and through /actuator/health we can see the state of the circuitbreaker
	- API gateway - Configure by adding the starter gateway along with other services name for rerouting in app.properties or yaml file
				  - All apis are configured in API gateway only
	- Zipkin server - To monitor all the api calls
					- Add zipkin and sleuth dependencies and configure in respective service yml file to register on zipkin server
