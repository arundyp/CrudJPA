package com.example.demo.service;

import com.example.demo.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    User CreateUser(User user);

    List<User> getAllUsers();

    void deleteUser(int id);

    User getUserById(int id);

    List<User> findUsersByCity(String city);

    //boolean checkEmailExists(String email);

    public List<User> findUsersByDateRange(LocalDate startDate, LocalDate endDate);

}
