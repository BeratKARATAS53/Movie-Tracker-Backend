package com.obss.movieTracker.service;

import com.obss.movieTracker.model.Role;

import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    Iterable<Role> getAllRoles();

    Role getRoleById(Long id);

    Role saveRole(Role role);

    Role addRole(String name) throws Error;

    Role updateRole(Role role) throws Error;

    void deleteRoleById(Long id) throws Error;

}
