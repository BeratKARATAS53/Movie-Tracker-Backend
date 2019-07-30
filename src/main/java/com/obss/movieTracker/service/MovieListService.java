package com.obss.movieTracker.service;

import org.springframework.stereotype.Service;

import java.util.Set;

import com.obss.movieTracker.model.MovieList;
import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.model.Movie;

@Service
public interface MovieListService {

    Iterable<MovieList> getAllMovieLists();

    MovieList getMovieListById(Long id);

    MovieList saveMovieList(MovieList movieList);

    MovieList addMovieList(String name, Set<Movie> movies, Users user);

    MovieList updateMovieList(MovieList movieList);

    void deleteMovieListById(Long id);

}
