package com.obss.movieTracker;

import java.text.ParseException;
/* import java.util.Arrays;

import com.obss.movieTracker.model.Role;
import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.model.Director;
import com.obss.movieTracker.model.Movie;

import java.util.Date;
import java.util.List;

import com.obss.movieTracker.repository.DirectorRepository;
import com.obss.movieTracker.repository.MovieRepository;

import com.obss.movieTracker.repository.UserRepository;
import com.obss.movieTracker.service.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; */
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
		
		First Admin Adding
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		Users admin = new Users("FirstAdmin", "First", "Admin", "admin@gmail.com", "password",
				Arrays.asList(new Role("ROLE_ADMIN")));
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		userServ.saveUser(admin);
		Users user = new Users("FirstUser", "First", "User", "user@gmail.com", "password",
				Arrays.asList(new Role("ROLE_USER")));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userServ.saveUser(user);
		
		Users user1 = new Users("Ali123", "a@c", "ali", "kara", "123");
		Users user2 = new Users("Veli234", "v@c", "veli", "beyaz", "234");
		Users user3 = new Users("Berat345", "b@c", "berat", "taş", "345");
		
		Director director1 = new Director("Benedict", "Cumberbach", new Date(), "London");
		Director director2 = new Director("Quantin", "Tarantino", new Date(), "USA");
		
		Movie movie1 = new Movie("Sherlock", director1, new Date(), 9.5, "3h", "Police");
		Movie movie2 = new Movie("Forever", director2, new Date(), 9.2, "2h", "Doctor");
		
		user1.getMovies().add(movie1);
		user1.getMovies().add(movie2);
		movie1.getUsers().add(user1);
		movie2.getUsers().add(user1);
		
		userServ.saveUser(user1);
		userServ.saveUser(user2);
		userServ.saveUser(user3);
		
		movieRep.save(movie1);
		movieRep.save(movie2);
		
		directorRep.save(director1);
		directorRep.save(director2); */
	}
}
