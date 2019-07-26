package com.obss.movieTracker.repository;

import com.obss.movieTracker.model.UserMovieList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMovieListRepository extends CrudRepository<UserMovieList, Integer> {
}