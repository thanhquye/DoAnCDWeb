package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.CommentDTO;
import com.example.Movie_Ticket_Website.dto.UserCommentWithMovieDTO;
import com.example.Movie_Ticket_Website.model.Customer;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.model.UserComment;
import com.example.Movie_Ticket_Website.repository.CustomerRepository;
import com.example.Movie_Ticket_Website.repository.MovieRepository;
import com.example.Movie_Ticket_Website.repository.UserCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserCommentService {
    private UserCommentRepository userCommentRepository;

    @Autowired
    public UserCommentService(UserCommentRepository userCommentRepository) {
        this.userCommentRepository = userCommentRepository;
    }

    public List<CommentDTO> getAllComments() {
        return userCommentRepository.getAllComment();
    }

    public List<CommentDTO> getCommentsByMovieId(String movieId) {
        return userCommentRepository.getAllCommentByMovieID(movieId);
    }

    public List<UserCommentWithMovieDTO> getPopularComment(int number) {
        Pageable pageable = PageRequest.of(0, number);
        return userCommentRepository.findPopularComment(pageable);
    }

    // admin
    @Transactional
    public void deleteCommentById(String commentID) {
        System.out.println("Đã chọn commentID: " + commentID);
        userCommentRepository.deleteCommentByCustomId(commentID);
    }

    // chức năng comment
// Inject thêm CustomerRepository và MovieRepository để lấy entity
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public UserComment addComment(String customerID, String movieID, String commentText) {
        Customer customer = customerRepository.findById(customerID).orElseThrow(() -> new RuntimeException("Customer not found"));
        Movie movie = movieRepository.findById(movieID).orElseThrow(() -> new RuntimeException("Movie not found"));

        UserComment comment = new UserComment();
        comment.setCommentID(UUID.randomUUID().toString()); // tạo ID mới
        comment.setCommentText(commentText);
        comment.setCustomer(customer);
        comment.setMovie(movie);

        return userCommentRepository.save(comment);
    }

}
