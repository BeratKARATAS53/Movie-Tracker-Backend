package com.obss.movieTracker.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestBody {

    private String user;
    private String movie;
    private String director;

}