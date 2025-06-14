package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, String> {

}
