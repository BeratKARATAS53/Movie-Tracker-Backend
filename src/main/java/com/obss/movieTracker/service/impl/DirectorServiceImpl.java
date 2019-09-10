package com.obss.movieTracker.service.impl;

import java.util.Optional;

import com.obss.movieTracker.model.Director;
import com.obss.movieTracker.repository.DirectorRepository;
import com.obss.movieTracker.service.DirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRep;

    @Override
    public Iterable<Director> getDirectors() {
        return directorRep.findAll();
    }

    public void addDirector(Director director) {
        directorRep.save(director);
    }

    public boolean deleteDirector(Integer id) {
        Optional<Director> dExist = directorRep.findById(id);
        if (dExist.isPresent()) {
            directorRep.delete(dExist.get());
            return true;
        }
        return false;
    }

    public boolean updateDirector(Director director) {
        Optional<Director> dExist = directorRep.findById(director.getId());
        if (dExist.isPresent()) {
            directorRep.delete(dExist.get());
            directorRep.save(director);
            return true;
        }
        return false;
    }
}