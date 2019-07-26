package com.obss.movieTracker.repository;

import java.util.List;

import com.obss.movieTracker.model.DirectorModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<DirectorModel, Integer> {

}