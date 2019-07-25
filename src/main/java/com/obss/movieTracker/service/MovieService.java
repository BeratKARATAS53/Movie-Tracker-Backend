package com.obss.movieTracker.service;

import java.util.List;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.repository.MovieRepository;
import com.obss.movieTracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private UserRepository userRep;
    @Autowired
    private MovieRepository movieRep;

    MovieService() {
    }

    public List<Movie> addMovies() {
        return null;
    }

    public List<Movie> deleteMovies() {
        return null;
    }

    public List<Movie> updateMovies() {
        return null;
    }
}