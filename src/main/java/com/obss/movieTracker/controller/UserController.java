package com.obss.movieTracker.controller;

import java.util.Optional;

import com.obss.movieTracker.model.Users;
import com.obss.movieTracker.repository.UserRepository;
import com.obss.movieTracker.service.AdminService;
import com.obss.movieTracker.service.impl.UserServiceImpl;

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
    private UserServiceImpl userServiceImpl;
    @Autowired
    private UserRepository userRep;
    @Autowired
    private AdminService adminServ;

    @GetMapping()
    private Iterable<Users> getUserList() {
        return userRep.findAll();
    }

    @PostMapping
    private ResponseEntity<?> addUser(@RequestBody Users user) {
        if (adminServ.addUser(user)) {
            userServiceImpl.saveUser(user);
            return new ResponseEntity<>("Yeni Kullanıcı Eklendi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Kullanıcı Zaten Sistemde Kayıtlı", HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        if (adminServ.deleteUser(id)) {
            userRep.deleteById(id);
            return new ResponseEntity<>("Kullanıcı Silindi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Kullanıcı Sistemde Bulunamamakta!", HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<?> updateUser(@RequestBody Users user) {
        if (adminServ.updateUser(user)) {
            Optional<Users> uOpt = userRep.findById(user.getId());
            userRep.deleteById(uOpt.get().getId());
            userServiceImpl.saveUser(user);
            return new ResponseEntity<>("Kullanıcı Güncellendi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Kullanıcı Sistemde Bulunamamakta!", HttpStatus.OK);
    }

    public void search(Users user) {
        adminServ.search(user);
    }
}