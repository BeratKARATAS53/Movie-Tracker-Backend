package com.obss.movieTracker.service.impl;

import java.util.Optional;

import com.obss.movieTracker.model.Role;
import com.obss.movieTracker.repository.RoleRepository;
import com.obss.movieTracker.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Integer id) throws Error {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent())
            return role.get();
        throw new Error("Role Does Not Exists!");
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role addRole(String name) throws Error {
        if (!roleRepository.existsByName(name))
            return saveRole(new Role(2, name));
        throw new Error("Role Does Not Exists!");

    }

    @Override
    public Role updateRole(Role role) throws Error {
        if (roleRepository.existsById(role.getId()))
            return roleRepository.save(role);
        throw new Error("Role Does Not Exists!");
    }

    @Override
    public void deleteRoleById(Integer id) throws Error {
        if (roleRepository.existsById(id))
            roleRepository.delete(getRoleById(id));
        throw new Error("Role Does Not Exists!");
    }

}
