package com.obss.movieTracker.repository;

import com.obss.movieTracker.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);

    Users findByEmail(String email);

    boolean existsByUsername(String username);
}