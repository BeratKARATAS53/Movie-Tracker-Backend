package com.obss.movieTracker.controller;

import com.obss.movieTracker.model.request.LoginRequestBody;
import com.obss.movieTracker.service.impl.LoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/rest/login")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestBody loginRequestBody) {
        String token = loginServiceImpl.login(loginRequestBody);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
