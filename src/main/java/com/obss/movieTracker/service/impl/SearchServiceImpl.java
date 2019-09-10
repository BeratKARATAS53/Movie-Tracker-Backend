package com.obss.movieTracker.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.request.SearchRequestBody;
// import com.obss.movieTracker.repository.UserRepository;
// import com.obss.movieTracker.repository.DirectorRepository;
import com.obss.movieTracker.repository.MovieRepository;
import com.obss.movieTracker.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private MovieRepository movieRep;
    // @Autowired
    // private UserRepository userRep;
    // @Autowired
    // private DirectorRepository directorRep;

    @Override
    public List<Movie> searchList(SearchRequestBody searchRequestBody) {
        List<Movie> list = new ArrayList<>();

        // if (searchRequestBody.getUser() != null && !searchRequestBody.getUser().isEmpty())
        //     list.add(userRep.searchUsers(searchRequestBody.getUser()));

        if (searchRequestBody.getMovie() != null && !searchRequestBody.getMovie().isEmpty())
            list = movieRep.searchMovies(searchRequestBody.getMovie());

        // else if (searchRequestBody.getDirector() != null && !searchRequestBody.getDirector().isEmpty())
        //     list.add(directorRep.searchDirectors(searchRequestBody.getDirector()));

        return list;
    }

}
