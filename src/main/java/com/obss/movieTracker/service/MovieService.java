package com.obss.movieTracker.service;

import java.util.List;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRep;

    MovieService() {
    }

    public void addMovies(Movie movie) {
        movieRep.save(movie);
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