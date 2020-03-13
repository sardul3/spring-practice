package com.sagar.sprrestdatademo.controller;

import com.sagar.sprrestdatademo.exception.UserNotFoundException;
import com.sagar.sprrestdatademo.model.User;
import com.sagar.sprrestdatademo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userServiceImpl.findAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUser(@PathVariable int userId) {
        Optional<User> user =  userServiceImpl.findById(userId);

        //TODO: find a way to work with optional java constructs
        if(user.get() == null){
            System.out.println("USER not found");
            throw new UserNotFoundException("id: ");
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User savedUser =  userServiceImpl.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
       userServiceImpl.deleteById(id);
    }
}
