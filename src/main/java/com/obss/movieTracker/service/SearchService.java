package com.obss.movieTracker.service;

import java.util.List;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.request.SearchRequestBody;

import org.springframework.stereotype.Service;

@Service
public interface SearchService {

    List<Movie> searchList(SearchRequestBody searchRequestBody);

}
