package com.obss.movieTracker.controller;

import java.util.Optional;

import com.obss.movieTracker.model.User;
import com.obss.movieTracker.repository.UserRepository;
import com.obss.movieTracker.service.AdminService;
import com.obss.movieTracker.service.LoginService;
import com.obss.movieTracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRep;
    @Autowired
    private AdminService adminServ;

    @GetMapping()
    private Iterable<User> getUserList() {
        return userRep.findAll();
    }

    @PostMapping
    private ResponseEntity<?> addUser(@RequestBody User user) {
        if (adminServ.addUser(user)) {
            userRep.save(user);
            return new ResponseEntity<>("Yeni Kullanıcı Eklendi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Kullanıcı Zaten Sistemde Kayıtlı", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        if (adminServ.deleteUser(id)) {
            userRep.deleteById(id);
            return new ResponseEntity<>("Kullanıcı Silindi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Kullanıcı Sistemde Bulunamamakta!", HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<?> updateUser(@RequestBody User user) {
        if (adminServ.updateUser(user)) {
            Optional<User> uOpt = userRep.findById(user.getId());
            userRep.deleteById(uOpt.get().getId());
            userRep.save(user);
            return new ResponseEntity<>("Kullanıcı Güncellendi!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hata! Kullanıcı Sistemde Bulunamamakta!", HttpStatus.OK);
    }

}