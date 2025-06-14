package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Vì mối quan hệ đã được ánh xạ qua UserLogin, tùy chọn:
    Customer findByUserLogin_UserId(String userId);

    @Query("select new com.example.Movie_Ticket_Website.model.Customer(c.customerID, c.fullName, c.gender, c.address, c.phoneNumber, c.dob)" +
            "from Customer c " +
            "WHERE c.customerID =:customerId")
    Customer findByCustomerID(@Param("customerId") String customerId);
}