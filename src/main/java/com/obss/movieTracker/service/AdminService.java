package com.obss.movieTracker.service;

import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRep;

    AdminService() {
    }

    public boolean addUser(Users user) {
        Users users = userRep.findByUsername(user.getUsername());
        if (users == null) {
            return true;
        }
        return false;
    }

    public boolean deleteUser(Integer id) {
        if (userRep.existsById(id)) {
            return true;
        }
        return false;
    }

    public boolean updateUser(Users user) {
        Users users = userRep.findByUsername(user.getUsername());
        if (users != null) {
            System.out.println(users);
            return true;
        }
        return false;
    }

    public Users search(Users user) {
        Users users = userRep.findByUsername(user.getUsername());
        if (users != null) {
            return user;
        }
        return null;
    }
}