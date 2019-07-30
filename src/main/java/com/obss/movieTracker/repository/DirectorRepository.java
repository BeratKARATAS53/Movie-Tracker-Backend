package com.obss.movieTracker.repository;

import com.obss.movieTracker.model.Director;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    Director findByDirectorName(String name);
}