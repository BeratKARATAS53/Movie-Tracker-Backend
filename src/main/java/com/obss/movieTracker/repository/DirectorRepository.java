package com.obss.movieTracker.repository;

import java.util.Optional;

import com.obss.movieTracker.model.Director;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Integer> {
    Optional<Director> findByDirectorName(String name);
}