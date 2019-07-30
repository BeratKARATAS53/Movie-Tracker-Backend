package com.obss.movieTracker.service.impl;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.MovieList;
import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.repository.MovieListRepository;
import com.obss.movieTracker.service.MovieListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieListServiceImpl implements MovieListService {

    @Autowired
    private MovieListRepository movieListRepository;

    @Override
    public Iterable<MovieList> getAllMovieLists() {
        return movieListRepository.findAll();
    }

    @Override
    public MovieList getMovieListById(Long id) throws EntityNotFoundException {
        Optional<MovieList> movieList = movieListRepository.findById(id);
        if (movieList.isPresent())
            return movieList.get();
        throw new EntityNotFoundException(String.format("Movie list with id %s not found!", id));
    }

    @Override
    public MovieList saveMovieList(MovieList movieList) {
        return movieListRepository.save(movieList);
    }

    @Override
    public MovieList addMovieList(String name, Set<Movie> movies, Users user) {
        MovieList movieList = new MovieList(name, movies, user);
        return saveMovieList(movieList);
    }

    @Override
    public MovieList updateMovieList(MovieList movieList) throws EntityNotFoundException {
        if (movieListRepository.existsById(movieList.getId()))
            return movieListRepository.save(movieList);
        throw new EntityNotFoundException(String.format("Movie list with id %s does not exists!", movieList.getId()));
    }

    @Override
    public void deleteMovieListById(Long id) throws EntityNotFoundException {
        if (movieListRepository.existsById(id))
            movieListRepository.delete(getMovieListById(id));
        throw new EntityNotFoundException(String.format("Movie list with id %s does not exists!", id));
    }

}
