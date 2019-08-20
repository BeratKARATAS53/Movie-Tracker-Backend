package com.obss.movieTracker.service;

import java.util.Optional;

import com.obss.movieTracker.model.Director;
import com.obss.movieTracker.repository.DirectorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRep;

    DirectorService() {
    }

    public void addDirector(Director director) {
        directorRep.save(director);
    }

    public boolean deleteDirector(Integer id) {
        if (directorRep.existsById(id)) {
            return true;
        }
        return false;
    }

    public boolean updateDirector(Director director) {
        Optional<Director> dExist = directorRep.findById(director.getId());
        if (dExist.isPresent()) {
            return true;
        }
        return false;
    }
}