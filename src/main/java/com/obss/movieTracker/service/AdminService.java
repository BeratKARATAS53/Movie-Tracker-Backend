package com.obss.movieTracker.service;

import java.util.Optional;
import java.util.List;

import com.obss.movieTracker.model.Director;
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

    public boolean addUser(User user) {
        Optional<User> uList = userRep.findByUsername(user.getUsername());
        if (!uList.isPresent()) {
            return true;
        }
        return false;
    }

    public boolean deleteUser(int id) {
        if (userRep.existsById(id)) {
            return true;
        }
        return false;
    }

    public boolean updateUser(User user) {
        Optional<User> uList = userRep.findByUsername(user.getUsername());
        if (uList.isPresent()) {
            System.out.println(uList.get());
            return true;
        }
        return false;
    }

    public List<Movie> search(User user) {
        return null;
    }

    public List<Movie> search(Movie movie) {
        return null;
    }

    public List<Movie> search(Director Director) {
        return null;
    }

}