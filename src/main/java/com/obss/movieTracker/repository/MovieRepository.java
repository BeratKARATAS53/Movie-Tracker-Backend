package com.obss.movieTracker.repository;

import java.util.List;

import com.obss.movieTracker.model.Movie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findByMovieName(String movieName);

    List<Movie> findAllByMovieName(String movieName);
}