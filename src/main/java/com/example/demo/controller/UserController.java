package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {
@Autowired
    private UserService userService;

//will implement later
/*
    ResponseEntity<User> getUserByEmail(String email) {
        User userByEmail = this.userService.getUserById(email);
        return ResponseEntity.ok(userByEmail);
    }*/
@PostMapping("/createUser")
    ResponseEntity<User> cretateUser(@RequestBody User user) {
        User createdUser = this.userService.CreateUser(user);
        return ResponseEntity.ok(createdUser);
    }
@GetMapping("/getUserById/{id}")
    ResponseEntity<User> findUserById(int id) {
        User userById = this.userService.getUserById(id);
        return ResponseEntity.ok(userById);
    }
@PutMapping("/updateUser")
    ResponseEntity<User> updateUser(User user) {
        User updatedUser = this.userService.CreateUser(user);
        return ResponseEntity.ok(updatedUser);
    }
@GetMapping("/getAllUsers")
    ResponseEntity<User> findAllUsers() {
        User allUsers = (User) this.userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
@GetMapping("/findByJoingDate/{startDate}/{endDate}")
    ResponseEntity<List<User>> findAllUsersByDateRange(@PathVariable LocalDate startDate,@PathVariable LocalDate endDate) {
        List<User> date = this.userService.findUsersByDateRange(startDate, endDate);
        return new ResponseEntity<>(date, HttpStatus.OK);
    }
@GetMapping("/findByCity/{city}")
    ResponseEntity<List<User>> findAllUsersByCity(@PathVariable String city) {
        List<User> usersByCity = this.userService.findUsersByCity(city);
        return ResponseEntity.ok(usersByCity);
    }
}
