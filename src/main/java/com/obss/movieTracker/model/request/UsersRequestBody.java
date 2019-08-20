package com.obss.movieTracker.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersRequestBody {

    public UsersRequestBody() {

    }

    private String username;
    private String password;

    /**
     * @param username
     * @param password
     */

    public UsersRequestBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

}