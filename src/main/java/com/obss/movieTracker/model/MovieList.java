package com.obss.movieTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "movie_list")
public class MovieList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 120)
    @NotNull(message = "Movie list name can not be null!")
    @NotEmpty(message = "Movie list name can not be empty!")
    private String name;

    @Column(name = "movies", nullable = false)
    @NotNull(message = "Movies can not be null!")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_list_movies", joinColumns = {
            @JoinColumn(name = "movie_list_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "movie_id", referencedColumnName = "id") })
    private Set<Movie> movies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private Users user;

    public MovieList() {

    }

    public MovieList(String name, Set<Movie> movies, Users user) {
        this.name = name;
        this.movies = movies;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
