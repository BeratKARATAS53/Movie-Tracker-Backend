package com.obss.movieTracker.service.impl;

import java.util.List;
import java.util.Optional;

import com.obss.movieTracker.Error;
import com.obss.movieTracker.model.Role;
import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.repository.UserRepository;
import com.obss.movieTracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users getUserById(int id) throws Error {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent())
            return user.get();
        throw new Error("User Not Found!");
    }

    @Override
    public Users saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Users addUser(String username, String firstName, String lastName, String email, String password,
            List<Role> roles) throws Error {
        if (!userRepository.existsByUsername(username)) {
            Users user = new Users(username, firstName, email, lastName, password, roles);
            return saveUser(user);
        }
        throw new Error("Kullanıcı Zaten Sistemde Kayıtlı Bulunmakta!");
    }

    @Override
    public Users updateUser(Users user) throws Error {
        if (userRepository.existsById(user.getId()))
            return userRepository.save(user);
        throw new Error("User Not Found!");
    }

    @Override
    public void deleteUserById(int id) throws Error {
        if (userRepository.existsById(id))
            userRepository.delete(getUserById(id));
        throw new Error("User Does Not Exist in DB");
    }

}
