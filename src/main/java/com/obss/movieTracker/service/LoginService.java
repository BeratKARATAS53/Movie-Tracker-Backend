package com.obss.movieTracker.service;

import com.obss.movieTracker.model.User;
import com.obss.movieTracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRep;

    LoginService() {
    }

    public void login(User user) {
    }

}