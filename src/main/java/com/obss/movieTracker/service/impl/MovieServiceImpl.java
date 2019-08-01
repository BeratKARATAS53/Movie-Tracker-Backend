package com.obss.movieTracker.service.impl;

import java.text.ParseException;
import java.util.Optional;

import com.obss.movieTracker.Error;
import com.obss.movieTracker.model.Director;
import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.request.MovieRequestBody;
import com.obss.movieTracker.repository.DirectorRepository;
import com.obss.movieTracker.repository.MovieRepository;
import com.obss.movieTracker.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRep;
    @Autowired
    private DirectorRepository directorRep;

    @Override
    public Movie getMovieById(int id) throws Error {
        Optional<Movie> movie = movieRep.findById(id);
        if (movie.isPresent())
            return movie.get();
        throw new Error("Movie Not Found");
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRep.save(movie);
    }

    @Override
    public Movie addMovie(MovieRequestBody movie) throws ParseException {
        Optional<Director> director = directorRep.findById(movie.getDirectorId());
        Movie newMovie = new Movie(movie.getMovieName(), director.get(), movie.getReleaseDate(), movie.getImdbRate(),
                movie.getDuration(), movie.getGenre());
        return saveMovie(newMovie);
    }

    @Override
    public Movie updateMovie(Movie movie) throws Error {
        if (movieRep.existsById(movie.getId()))
            return movieRep.save(movie);
        throw new Error("Movie Not Found");
    }

    @Override
    public void deleteMovieById(int id) throws Error {
        if (movieRep.existsById(id))
            movieRep.delete(getMovieById(id));
        throw new Error("Movie Not Found");
    }
}
