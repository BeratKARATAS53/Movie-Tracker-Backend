package com.obss.movieTracker.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

import com.obss.movieTracker.model.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    Optional<Role> findByName(String name);

    boolean existsByName(String name);

}
