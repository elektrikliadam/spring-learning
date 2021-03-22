package com.example.api;

import java.util.List;
import java.util.Optional;

import com.example.entity.User;
import com.example.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;


@RestController
//@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/addUser")
    public String saveUser(@RequestBody User usr) {
        userRepository.save(usr);
        return "User added successfully::"+usr.getId();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/findUser/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "Deleted User Successfully::"+id;
    }


}