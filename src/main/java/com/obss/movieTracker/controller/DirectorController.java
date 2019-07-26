package com.obss.movieTracker.controller;

import java.util.Optional;

import com.obss.movieTracker.model.Director;
import com.obss.movieTracker.repository.DirectorRepository;
import com.obss.movieTracker.service.DirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    private DirectorRepository directorRep;
    @Autowired
    private DirectorService directorServ;

    @GetMapping
    private Iterable<Director> getDirectorList() {
        return directorRep.findAll();
    }

    @PostMapping
    private Iterable<Director> addDirector(@RequestBody Director director) {
        directorServ.addDirector(director);
        return getDirectorList();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteDirector(@PathVariable("id") int id) {
        if (directorServ.deleteDirector(id)) {
            directorRep.deleteById(id);
            return new ResponseEntity<>("Director Silindi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Director Sistemde Bulunamamakta!", HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<?> updateDirector(@RequestBody Director director) {
        if (directorServ.updateDirector(director)) {
            Optional<Director> uOpt = directorRep.findById(director.getId());
            directorRep.deleteById(uOpt.get().getId());
            directorRep.save(director);
            return new ResponseEntity<>("Director Güncellendi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Director Sistemde Bulunamamakta!", HttpStatus.OK);
    }

}