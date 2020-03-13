package com.sagar.sprrestdatademo.service;

import com.sagar.sprrestdatademo.model.User;
import com.sagar.sprrestdatademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int theId) {
        return userRepository.findById(theId);
    }

    @Override
    public User save(User theEmployee) {
        userRepository.save(theEmployee);
        return theEmployee;
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }
}
