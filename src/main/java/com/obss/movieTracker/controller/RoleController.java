package com.obss.movieTracker.controller;

import com.obss.movieTracker.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/rest/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(@Qualifier("roleServiceImpl") RoleService roleService) {
        this.roleService = roleService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRoleById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
