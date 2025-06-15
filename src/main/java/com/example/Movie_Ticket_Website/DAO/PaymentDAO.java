package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.model.Payment;
import com.example.Movie_Ticket_Website.repository.PaymentRepository;
import com.example.Movie_Ticket_Website.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDAO {
    @Autowired
    private PaymentService paymentService;

    public void all(){
        List<Payment> payments = paymentService.getAllPayments();
    }
}
