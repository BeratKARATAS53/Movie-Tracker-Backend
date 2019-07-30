package com.obss.movieTracker.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestBody {

    public LoginRequestBody() {

    }

    private String username;
    private String password;

    /**
     * @param username
     * @param password
     */

    public LoginRequestBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

}