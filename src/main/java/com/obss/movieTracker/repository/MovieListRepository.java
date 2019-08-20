package com.obss.movieTracker.repository;

import com.obss.movieTracker.model.MovieList;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieListRepository extends PagingAndSortingRepository<MovieList, Long> {

}
