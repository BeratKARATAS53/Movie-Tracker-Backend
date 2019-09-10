package com.obss.movieTracker.service.impl;

import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.model.request.UsersRequestBody;
import com.obss.movieTracker.repository.UserRepository;
import com.obss.movieTracker.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRep;

    @Override
    public Iterable<Users> getUsers() {
        return userRep.findAll();
    }

    public boolean addUser(Users user) {
        Users users = userRep.findByUsername(user.getUsername());
        if (users == null) {
            userRep.save(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(Integer id) {
        if (userRep.existsById(id)) {
            userRep.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateUser(UsersRequestBody usersRequestBody) {
        Users users = userRep.findByUsername(usersRequestBody.getUsername());
        if (users != null) {
            userRep.deleteById(users.getId());
            userRep.save(users);
            return true;
        }
        return false;
    }

    public boolean search(UsersRequestBody usersRequestBody) {
        Users users = userRep.findByUsername(usersRequestBody.getUsername());
        if (users != null) {
            return true;
        }
        return false;
    }

    public void search(Users user) {
        System.out.println(userRep.findAll());
    }

}