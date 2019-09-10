package com.obss.movieTracker.repository;

import java.util.List;

import com.obss.movieTracker.model.Movie;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findByMovieName(String movieName);

    List<Movie> findAllByMovieName(String movieName);

    @Query("Select m From Movie m Where lower(m.movieName) like lower(concat('%',:movieName,'%')) or :movieName is null")
    List<Movie> searchMovies(String movieName);
}