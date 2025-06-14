package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Vì mối quan hệ đã được ánh xạ qua UserLogin, tùy chọn:
    Customer findByUserlogin_UserId(String userId);
}