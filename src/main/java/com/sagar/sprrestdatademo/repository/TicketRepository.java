package com.sagar.sprrestdatademo.repository;
import com.sagar.sprrestdatademo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin()
@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}