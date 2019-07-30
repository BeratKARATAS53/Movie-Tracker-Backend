package com.obss.movieTracker.service;

import com.obss.movieTracker.Error;
import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.request.MovieRequestBody;

import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    Movie getMovieById(int id) throws Error;

    Movie saveMovie(Movie movie);

    Movie addMovie(MovieRequestBody movieRequestBody) throws Error;

    Movie updateMovie(Movie movie) throws Error;

    void deleteMovieById(int id) throws Error;
}