package com.obss.movieTracker.service;

import com.obss.movieTracker.model.Director;

public interface DirectorService {

    Iterable<Director> getDirectors();

    void addDirector(Director director);

    boolean updateDirector(Director director);

    boolean deleteDirector(Integer id);

}