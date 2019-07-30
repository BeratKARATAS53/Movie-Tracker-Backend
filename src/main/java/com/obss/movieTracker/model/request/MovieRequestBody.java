package com.obss.movieTracker.model.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRequestBody {

    public MovieRequestBody() {

    }

    private String movieName;
    private Date releaseDate;
    private Double imdbRate;
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

    public MovieRequestBody(String movieName, Date releaseDate, Double imdbRate, String duration, String genre,
            Integer directorId) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.imdbRate = imdbRate;
        this.duration = duration;
        this.genre = genre;
        this.directorId = directorId;
    }

}