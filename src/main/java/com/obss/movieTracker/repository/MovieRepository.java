package com.obss.movieTracker.repository;

import java.util.List;

import com.obss.movieTracker.model.Movie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByMovieName(String movieName);
}