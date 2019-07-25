package com.obss.movieTracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    private int id;
    @Column
    private String movieName;
    @Column
    private String director;
    @Column
    private Date releaseDate;
    @Column
    private Double IMDB_Rate;
    @Column
    private String duration;
    @Column
    private String genre;

    /**
     * @param movieName
     * @param director
     * @param releaseDate
     * @param iMDB_Rate
     * @param duration
     * @param genre
     */

    public Movie(String movieName, String director, Date releaseDate, Double iMDB_Rate, String duration, String genre) {
        this.movieName = movieName;
        this.director = director;
        this.releaseDate = releaseDate;
        IMDB_Rate = iMDB_Rate;
        this.duration = duration;
        this.genre = genre;
    }

}