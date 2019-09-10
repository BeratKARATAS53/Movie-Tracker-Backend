package com.obss.movieTracker;

import java.text.ParseException;
/* 
import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.model.Director;
import com.obss.movieTracker.model.Movie;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.obss.movieTracker.repository.DirectorRepository;
import com.obss.movieTracker.repository.MovieRepository;
import com.obss.movieTracker.service.UserService; */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieTrackerApplication {

	public static void main(String[] args) throws ParseException {

		ApplicationContext appContext = SpringApplication.run(MovieTrackerApplication.class, args);

		/* UserService userServ = appContext.getBean(UserService.class);
		MovieRepository movieRep = appContext.getBean(MovieRepository.class);
		DirectorRepository directorRep = appContext.getBean(DirectorRepository.class);
		
		// First Admin Adding
		
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		Director director1 = new Director("Benedict", "Cumberbach", new Date(), "London");
		Director director2 = new Director("Quantin", "Tarantino", new Date(), "USA");
		
		directorRep.save(director1);
		directorRep.save(director2);
		
		Movie movie1 = new Movie("Sherlock", director1, new Date(), 9.5, "3h", "Police");
		Movie movie2 = new Movie("Forever", director2, new Date(), 9.2, "2h", "Doctor");
		
		movieRep.save(movie1);
		movieRep.save(movie2);
		
		Set<Movie> movies = new HashSet<>();
		movies.add(movie1);
		movies.add(movie2);
		
		Users admin = new Users(1, "FirstAdmin", "admin@gmail.com", "First", "Admin", "password", "ROLE_ADMIN", movies);
		userServ.saveUser(admin);
		Users user = new Users(2, "FirstUser", "user@gmail.com", "First", "User", "password", "ROLE_USER", movies);
		userServ.saveUser(user); */
	}
}
