package com.obss.movieTracker.controller;

import com.obss.movieTracker.Error;
import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.model.request.UsersRequestBody;
import com.obss.movieTracker.service.impl.AdminServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/rest/users")
public class UserController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @GetMapping()
    private Iterable<Users> getUserList() throws Error {
        return adminServiceImpl.getUsers();
    }

    @PostMapping
    private ResponseEntity<?> addUser(@RequestBody Users user) {
        if (adminServiceImpl.addUser(user)) {
            return new ResponseEntity<>("Yeni Kullanıcı Eklendi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Kullanıcı Zaten Sistemde Kayıtlı", HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        if (adminServiceImpl.deleteUser(id)) {
            return new ResponseEntity<>("Kullanıcı Silindi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Kullanıcı Sistemde Bulunamamakta!", HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<?> updateUser(@RequestBody UsersRequestBody usersRequestBody) {
        if (adminServiceImpl.updateUser(usersRequestBody)) {
            return new ResponseEntity<>("Kullanıcı Güncellendi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Kullanıcı Sistemde Bulunamamakta!", HttpStatus.OK);
    }
}