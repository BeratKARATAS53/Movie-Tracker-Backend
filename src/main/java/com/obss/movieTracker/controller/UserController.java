package com.obss.movieTracker.controller;

import com.obss.movieTracker.repository.MovieRepository;
import com.obss.movieTracker.repository.UserRepository;
import com.obss.movieTracker.service.AdminService;
import com.obss.movieTracker.service.LoginService;
import com.obss.movieTracker.service.MovieService;
import com.obss.movieTracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRep;
    @Autowired
    private MovieRepository movieRep;
    @Autowired
    private AdminService adminServ;
    @Autowired
    private LoginService loginServ;
    @Autowired
    private UserService userServ;
    @Autowired
    private MovieService movieServ;

}