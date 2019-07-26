package com.obss.movieTracker.service;

import java.util.List;

import com.obss.movieTracker.model.DirectorModel;
import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.User;
import com.obss.movieTracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRep;

    AdminService() {
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

    public List<Movie> search(User user) {
        return null;
    }

    public List<Movie> search(Movie movie) {
        return null;
    }

    public List<Movie> search(DirectorModel Director) {
        return null;
    }

}