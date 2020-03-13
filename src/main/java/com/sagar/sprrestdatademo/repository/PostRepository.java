package com.sagar.sprrestdatademo.repository;

import com.sagar.sprrestdatademo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin()
@RepositoryRestResource
public interface PostRepository extends JpaRepository<Post, Integer> {
}
