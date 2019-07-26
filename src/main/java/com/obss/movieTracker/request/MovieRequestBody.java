package com.obss.movieTracker.request;

import java.util.Date;

import lombok.Getter;

@Getter
public class MovieRequestBody {

    public MovieRequestBody() {

    }

    private String movieName;
    private Date releaseDate;
    private Double IMDB_Rate;
    private String duration;
    private String genre;
    private Integer directorId;

    /**
     * @param movieName
     * @param releaseDate
     * @param iMDB_Rate
     * @param duration
     * @param genre
     * @param directorId
     */

    public MovieRequestBody(String movieName, Date releaseDate, Double iMDB_Rate, String duration, String genre,
            Integer directorId) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        IMDB_Rate = iMDB_Rate;
        this.duration = duration;
        this.genre = genre;
        this.directorId = directorId;
    }

}