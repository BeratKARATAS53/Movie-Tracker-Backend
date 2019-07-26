package com.obss.movieTracker.controller;

import com.obss.movieTracker.model.Movie;
import com.obss.movieTracker.model.User;
import com.obss.movieTracker.repository.MovieRepository;
import com.obss.movieTracker.repository.UserRepository;
import com.obss.movieTracker.service.AdminService;
import com.obss.movieTracker.service.LoginService;
import com.obss.movieTracker.service.MovieService;
import com.obss.movieTracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieContoller {

    @Autowired
    private UserRepository userRep;
    @Autowired
    private MovieRepository movieRep;
    @Autowired
    private MovieService movieServ;

    @GetMapping
    private ResponseEntity<?> getMovieList() {
        Iterable<Movie> iterable = movieRep.findAll();

        return new ResponseEntity<>(iterable, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addMovies(Movie movie) {
        if (!movieServ.addMovies(movie)) {
            return new ResponseEntity<>(new Error("Hatalı Ekleme İsteği! Zaten Film Ekli."), HttpStatus.CONFLICT);
        }
        movieRep.save(movie);
        return new ResponseEntity<>("Movie Eklendi!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovies(@PathVariable("id") int id) {
        if (!movieServ.deleteMovies(id)) {
            return new ResponseEntity<>(new Error("Hatalı Silme İsteği! Film Mevcut Değil."), HttpStatus.NOT_FOUND);
        }
        movieRep.deleteById(id);
        return new ResponseEntity<>("Movie Silindi!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateMovies(Movie movie) {
        if (!movieServ.updateMovies(movie)) {
            return new ResponseEntity<>(new Error("Hatalı Güncelleme İsteği! Film Mevcut Değil."),
                    HttpStatus.NOT_FOUND);
        }
        movieRep.deleteById(movie.getId());
        movieRep.save(movie);
        return new ResponseEntity<>("Movie Güncellendi!", HttpStatus.OK);
    }

}