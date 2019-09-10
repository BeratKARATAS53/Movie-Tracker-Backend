package com.obss.movieTracker.repository;

import java.util.List;

import com.obss.movieTracker.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

    Users findByEmail(String email);

    boolean existsByUsername(String username);

    @Query("Select u From Users u Where lower(u.username) like lower(concat('%',:username,'%')) or :username is null")
    List<Users> searchUsers(String username);

}