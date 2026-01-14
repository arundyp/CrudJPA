package com.example.demo.repository;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findByName(String name);
    public List<User> findByDateBetween(LocalDate startDate, LocalDate endDate);
    public List<User> findByEmail(String email);
    public List<User> findByCity(String city);
    public  Boolean existsByEmail(String email);
    public List<User> findByRole(String role);
    //arun
    public List<User> findByCityAndRole(String city, String role);
    public List<User> findByDateBetweenAndRole(LocalDate startDate, LocalDate endDate, String role);
}
