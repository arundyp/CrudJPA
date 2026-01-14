package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {
@Autowired
    private UserRepository userService;


    @Override
    public User CreateUser(User user) {
        Boolean exists = this.userService.existsByEmail(user.getEmail());
        if(exists==true){
            throw new RuntimeException("User with email "+user.getEmail()+" already exists");
        }else {
            User save = this.userService.save(user);
            return save;
        }

    }

    @Override
    public List<User> getAllUsers() {
       this.userService.findAll();
       return this.userService.findAll();
    }

    @Override
    public void deleteUser(int id) {
        this.userService.deleteById(id);

    }

    @Override
    public User getUserById(int id) {
        User byId = this.userService.findById(id).get();
        return byId;
    }
    @Override
    public List<User> findUsersByDateRange(LocalDate startDate, LocalDate endDate) {
        return userService.findByDateBetween(startDate, endDate);
    }
    @Override
    public List<User> findUsersByCity(String city) {
     return  this.userService.findByCity(city);
    }

}
