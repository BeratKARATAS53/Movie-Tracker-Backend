package com.obss.movieTracker.service;

import com.obss.movieTracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRep;

    LoginService() {
    }
    /*
     * public boolean login(String username, String password) { if
     * (userRep.existsById(username)) { Optional<User> user =
     * userRep.findById(username); if (user.get().getPassword().equals(password)) {
     * return true; } return false; } return false; }
     */

}