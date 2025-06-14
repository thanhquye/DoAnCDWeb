package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Customer;
import com.example.Movie_Ticket_Website.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerByUserId(String userId) {
        return customerRepository.findByCustomerID(userId);
    }

    // cập nhật customer
    public boolean updateCustomer(Customer newData) {
        Optional<Customer> opt = customerRepository.findById(newData.getCustomerID());
        if (opt.isPresent()) {
            Customer existing = opt.get();

            // Chỉ cập nhật các trường cần thiết
            existing.setFullName(newData.getFullName());
            existing.setGender(newData.getGender());
            existing.setPhoneNumber(newData.getPhoneNumber());
            existing.setAddress(newData.getAddress());
            existing.setDob(newData.getDob());

            // userID giữ nguyên
            customerRepository.save(existing);
            return true;
        } else {
            return false;
        }
    }

}
