package com.obss.movieTracker.controller;

import java.util.ArrayList;
import java.util.List;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.request.SearchRequestBody;
import com.obss.movieTracker.service.SearchService;
import com.obss.movieTracker.service.impl.SearchServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/rest/search")
public class SearchController {

    @Autowired
    private SearchServiceImpl searchServiceImpl;

    List<Movie> filterList = new ArrayList<>();

    @GetMapping
    public List<Movie> getFilterList() {
        System.out.println(filterList);
        return filterList;
    }

    @PostMapping
    public ResponseEntity<?> searchList(@RequestBody SearchRequestBody searchRequestBody) {
        System.out.println(searchRequestBody.toString());
        List<Movie> list = searchServiceImpl.searchList(searchRequestBody);

        filterList = list;

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
