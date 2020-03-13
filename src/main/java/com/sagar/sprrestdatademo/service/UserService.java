package com.sagar.sprrestdatademo.service;

import com.sagar.sprrestdatademo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();

    public Optional<User> findById(int theId);

    public User save(User theEmployee);

    public void deleteById(int theId);
}
