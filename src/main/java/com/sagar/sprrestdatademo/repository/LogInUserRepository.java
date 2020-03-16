package com.sagar.sprrestdatademo.repository;

import com.sagar.sprrestdatademo.model.LogInUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LogInUserRepository extends JpaRepository<LogInUser, Integer> {
    Optional<LogInUser> getUserByUserName(String userName);
}
