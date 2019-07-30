package com.obss.movieTracker.service;

import java.util.List;

import com.obss.movieTracker.Error;
import com.obss.movieTracker.model.Role;
import com.obss.movieTracker.model.Users;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Users getUserById(int id) throws Error;

    Users saveUser(Users user);

    Users addUser(String username, String firstName, String lastName, String email, String password, List<Role> roles)
            throws Error;

    Users updateUser(Users user) throws Error;

    void deleteUserById(int id) throws Error;
}
