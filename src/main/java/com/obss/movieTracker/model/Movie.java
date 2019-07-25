package com.obss.movieTracker.model;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {

    Movie() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "movies")
    private Set<User> users = new HashSet<>();
    /*
     * @ManyToOne(cascade = CascadeType.ALL)
     * 
     * @JoinColumn(name = "director_id", referencedColumnName = "id") private
     * Director owner;
     */

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Movie [IMDB_Rate=" + IMDB_Rate + ", director=" + director + ", duration=" + duration + ", genre="
                + genre + ", id=" + id + ", movieName=" + movieName + ", releaseDate=" + releaseDate + ", users="
                + users + "]";
    }

}