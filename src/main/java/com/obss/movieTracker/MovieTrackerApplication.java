package com.obss.movieTracker;

import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.User;
import com.obss.movieTracker.repository.MovieRepository;
import com.obss.movieTracker.repository.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovieTrackerApplication {

	public static void main(String[] args) {

		ApplicationContext appContext = SpringApplication.run(MovieTrackerApplication.class, args);

		UserRepository userRep = appContext.getBean(UserRepository.class);

		User user3 = new User("Berat7", "email3", "Berat", "7", "password3");

		Movie movie3 = new Movie("Forever", "Tarantino", new Date(), 8.5, "3.5h", "Doktor");

		user3.getMovies().add(movie3);
		Optional<User> users = userRep.findById(1L);

		movie3.getUsers().add(user3);

		userRep.save(user3);

		Iterable<User> user = userRep.findAll();
		for (User use : user) {
			System.out.println(use.getMovies().toString());
		}
	}

}
