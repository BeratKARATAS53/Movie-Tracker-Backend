package com.obss.movieTracker.service;

import com.obss.movieTracker.model.request.LoginRequestBody;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    String login(LoginRequestBody loginRequestBody);

}
