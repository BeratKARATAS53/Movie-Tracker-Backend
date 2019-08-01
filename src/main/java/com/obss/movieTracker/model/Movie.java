package com.obss.movieTracker.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {

    public Movie() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String movieName;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate;
    @Column
    private Double imdbRate;
    @Column
    private String duration;
    @Column
    private String genre;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "movies")
    @JsonIgnore
    private Set<Users> users = new HashSet<>();

    @ManyToOne
    private Director director;

    /**
     * @param movieName
     * @param director
     * @param releaseDate
     * @param iMDB_Rate
     * @param duration
     * @param genre
     * @throws ParseException
     */

    public Movie(String movieName, Director director, Date releaseDate, Double imdbRate, String duration, String genre)
            throws ParseException {
        this.movieName = movieName;
        this.director = director;

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String dateString = format.format(releaseDate);
        Date date = format.parse(dateString);

        this.releaseDate = date;
        this.imdbRate = imdbRate;
        this.duration = duration;
        this.genre = genre;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Movie [IMDB_Rate=" + imdbRate + ", director=" + director + ", duration=" + duration + ", genre=" + genre
                + ", id=" + id + ", movieName=" + movieName + ", releaseDate=" + releaseDate;
    }

}