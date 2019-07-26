package com.obss.movieTracker.repository;

import java.util.List;

import com.obss.movieTracker.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUsername(String username);
}