package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.TicketWithCustomerDTO;
import com.example.Movie_Ticket_Website.model.Booking;
import com.example.Movie_Ticket_Website.model.ShowTime;
import com.example.Movie_Ticket_Website.model.Ticket;
import com.example.Movie_Ticket_Website.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private ShowTimeService showTimeService;



    @Autowired
    public TicketService(TicketRepository ticketRepository, ShowTimeService showTimeService) {
        this.ticketRepository = ticketRepository;
        this.showTimeService = showTimeService;
    }



    public long getTicketCount() {
        return ticketRepository.count();
    }

    public List<TicketWithCustomerDTO> getAllTicket() {
        return ticketRepository.findAllTicket();
    }

    // get by CinemaID
    public List<Ticket> getAllTicketByMovieID(String cinemaID) {
        return ticketRepository.findAllByCinemaID(cinemaID);
    }

    // thêm ticket by date and time
    public Ticket addTicket(Booking booking,String date, String time) {
        // Tìm ID lớn nhất
        List<Ticket> tickets = ticketRepository.findAll();
        int maxId = tickets.stream()
                .mapToInt(u -> Integer.parseInt(u.getTicketID().replaceAll("[^0-9]", "")))
                .max()
                .orElse(0);
        String newTicketID = "tk" + (maxId + 1);

        ShowTime showTime = showTimeService.getShowTimeByDayAndStartTime(date, time);

        Ticket ticket = new Ticket();
        ticket.setTicketID(newTicketID);
        ticket.setBooking(booking);
        ticket.setShowTime(showTime);

        ticketRepository.save(ticket);

        return ticket;
    }

    public List<Ticket> getAllTicketByBooking(Booking booking) {
        return ticketRepository.findAllByBooking(booking);
    }


}
