package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Payment;
import com.example.Movie_Ticket_Website.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
