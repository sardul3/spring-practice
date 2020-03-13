package com.sagar.sprrestdatademo.repository;

import com.sagar.sprrestdatademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
