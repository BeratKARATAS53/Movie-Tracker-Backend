package com.obss.movieTracker.service;

import java.util.List;
import java.util.Optional;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.repository.MovieRepository;
import com.obss.movieTracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRep;

    MovieService() {
    }

    public boolean addMovies(Movie movie) {
        if (movieRep.findByMovieName(movie.getMovieName()).size() != 0) {
            return false;
        }
        return true;
    }

    public boolean deleteMovies(int id) {
        if (!movieRep.existsById(id)) {
            return false;
        }
        movieRep.deleteById(id);
        return true;
    }

    public boolean updateMovies(Movie movie) {
        List<Movie> movies = movieRep.findByMovieName(movie.getMovieName());
        if (movies == null) {
            return false;
        }
        movieRep.deleteById(movie.getId());
        movieRep.save(movie);
        return true;
    }
}