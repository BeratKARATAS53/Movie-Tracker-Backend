package com.obss.movieTracker;

/*
import java.util.Date;
import java.util.List;

import com.obss.movieTracker.model.DirectorModel;
import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.User;
*/
import com.obss.movieTracker.repository.DirectorRepository;
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
		MovieRepository movieRep = appContext.getBean(MovieRepository.class);
		DirectorRepository directorRep = appContext.getBean(DirectorRepository.class);
		/*
				User user1 = new User("user", "Ali123", "a@c", "ali", "kara", "123");
				User user2 = new User("user", "Veli234", "v@c", "veli", "beyaz", "234");
				User user3 = new User("admin", "Berat345", "b@c", "berat", "taş", "345");
		
				Movie movie1 = new Movie("Sherlock", "Benedict", new Date(), 9.5, "3h", "Police");
				Movie movie2 = new Movie("Forever", "Tarantino", new Date(), 9.2, "2h", "Doctor");
		
				DirectorModel director1 = new DirectorModel("Benedict", "Cumberbach", new Date(), "London");
				DirectorModel director2 = new DirectorModel("Quantin", "Tarantino", new Date(), "USA");
		
				user1.getMovies().add(movie1);
				user1.getMovies().add(movie2);
				movie1.getUsers().add(user1);
				movie2.getUsers().add(user1);
		
				userRep.save(user1);
				userRep.save(user2);
				userRep.save(user3);
				
				movieRep.save(movie1); movieRep.save(movie2);
				 
				directorRep.save(director1);
				directorRep.save(director2);*
		*/
		/*
				userRep.save(new User("user", "Veli1", "v@g", "Veli", "Elli", "veli1"));
		
				List<User> user = userRep.findByUsername("Veli1");
		
				user.get(0).getMovies().add(movieRep.findByMovieName("Forever").get(0));
				movieRep.findByMovieName("Forever").get(0).getUsers().add(user.get(0));
		
				userRep.save(user.get(0));
				movieRep.save(movieRep.findByMovieName("Forever").get(0));
		
				System.out.println(user.get(0).getMovies());*/
	}
}
