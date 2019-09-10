package com.obss.movieTracker.repository;

import java.util.List;

import com.obss.movieTracker.model.Director;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

    Director findByDirectorName(String name);

    @Query("Select d From Director d Where lower(d.directorName) like lower(concat('%',:directorName,'%')) or :directorName is null")
    List<Director> searchDirectors(String directorName);

}