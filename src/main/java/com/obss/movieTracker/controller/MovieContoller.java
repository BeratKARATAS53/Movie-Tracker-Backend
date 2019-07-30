package com.obss.movieTracker.controller;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.request.MovieRequestBody;
import com.obss.movieTracker.repository.MovieRepository;
import com.obss.movieTracker.service.impl.MovieServiceImpl;
import com.obss.movieTracker.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/movies")
public class MovieContoller {

    @Autowired
    private MovieRepository movieRep;
    @Autowired
    private MovieServiceImpl movieServImpl;

    @GetMapping
    private Iterable<Movie> getMovieList(@RequestParam(name = "name", required = false) String movieName) {
        if (movieName == null) {
            return movieRep.findAll();
        }
        return movieRep.findAllByMovieName(movieName);
    }
    /*
    @GetMapping("/search")
    public Iterable<Movie> search(Movie movie) {
        Iterable<Movie> movieList = getMovieList();
        for(Movie movies: movieList) {
            if(movies.getMovieName().equals(movie.getMovieName())) {
    
            }
        }
        List<Movie> mExist = movieRep.findByMovieName(movie.getMovieName());
        return mExist;
    
    }*/

    @PostMapping
    public void addMovies(@RequestBody MovieRequestBody movie) {
        movieServImpl.addMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovies(@PathVariable("id") Integer id) throws Error {
        movieServImpl.deleteMovieById(id);
    }

    @PutMapping
    public void updateMovies(@RequestBody Movie movie) throws Error {
        movieServImpl.updateMovie(movie);
    }

}