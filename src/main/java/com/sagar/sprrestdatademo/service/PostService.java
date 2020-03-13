package com.sagar.sprrestdatademo.service;

import com.sagar.sprrestdatademo.model.Post;
import com.sagar.sprrestdatademo.model.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<Post> findAll();

    public Optional<Post> findById(int theId);

    public Post save(Post thePost);

    public void deleteById(int theId);
}
