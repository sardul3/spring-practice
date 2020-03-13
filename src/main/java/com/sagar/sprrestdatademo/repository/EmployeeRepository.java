package com.sagar.sprrestdatademo.repository;

import com.sagar.sprrestdatademo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//@RepositoryRestResource(path="members")
@CrossOrigin()
@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
