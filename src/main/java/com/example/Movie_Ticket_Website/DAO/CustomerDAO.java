package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.model.Customer;
import com.example.Movie_Ticket_Website.repository.CustomerRepository;
import com.example.Movie_Ticket_Website.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDAO {

    @Autowired
    private CustomerService customerService;

    public void all(){
        Customer customer = customerService.getCustomerByUserId("Cus1");
        Customer newcCustomer = new Customer("Cus2", "SANG", "Nam" , "Hà nội", "0912827812", "2003-03-23");
        Boolean updateCustomer = customerService.updateCustomer(newcCustomer);
    }
}
