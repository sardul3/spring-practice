package com.sagar.sprrestdatademo.controller;

import com.sagar.sprrestdatademo.exception.UserNotFoundException;
import com.sagar.sprrestdatademo.model.Post;
import com.sagar.sprrestdatademo.model.User;
import com.sagar.sprrestdatademo.service.PostServiceImpl;
import com.sagar.sprrestdatademo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserServiceImpl userServiceImpl;
    private PostServiceImpl postServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, PostServiceImpl postServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.postServiceImpl = postServiceImpl;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userServiceImpl.findAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUser(@PathVariable int userId) {
        Optional<User> user =  userServiceImpl.findById(userId);

        //TODO: find a way to work with optional java constructs
        if(!user.isPresent()){
            System.out.println("USER not found");
            throw new UserNotFoundException("id: ");
        }
        return user;
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> getUserPosts(@PathVariable int userId) {
        Optional<User> user = userServiceImpl.findById(userId);
        if(!user.isPresent())
            throw new UserNotFoundException("user not found");
        return user.get().getPosts();

    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User savedUser =  userServiceImpl.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/users/{userId}/posts")
    public void addPost(@RequestBody Post post, @PathVariable int userId) {
        Optional<User> user = userServiceImpl.findById(userId);
        if(!user.isPresent())
            throw new UserNotFoundException("cannot create a new post (user not found)");
        User foundUser = user.get();
        post.setUser(foundUser);
        postServiceImpl.save(post);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
       userServiceImpl.deleteById(id);
    }

}
