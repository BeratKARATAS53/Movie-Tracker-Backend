package com.obss.movieTracker.service;

import java.util.List;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRep;

    UserService() {
    }

    public List<Movie> seeMovieList() {
        return null;

    }

    public void addWatchedList(Movie movie) {

    }

    public void addFavoriteList(Movie movie) {

    }

}