package com.obss.movieTracker.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequestBody {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

}