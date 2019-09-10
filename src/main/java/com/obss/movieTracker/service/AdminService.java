package com.obss.movieTracker.service;

import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.model.request.UsersRequestBody;

public interface AdminService {

    Iterable<Users> getUsers();

    boolean addUser(Users users);

    boolean updateUser(UsersRequestBody usersRequestBody);

    boolean deleteUser(Integer id);
}