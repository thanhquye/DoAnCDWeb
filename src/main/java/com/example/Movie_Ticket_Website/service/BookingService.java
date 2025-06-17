package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.beans.DateBean;
import com.example.Movie_Ticket_Website.model.Booking;
import com.example.Movie_Ticket_Website.model.BookingDetail;
import com.example.Movie_Ticket_Website.model.Ticket;
import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.repository.BookingDetailRepository;
import com.example.Movie_Ticket_Website.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private UserLoginService userLoginService;
    private TicketService ticketService;
    private BookingDetailRepository bookingDetailRepository;
    private DateBean dateBean;


    @Autowired
    public BookingService(BookingRepository bookingRepository, UserLoginService userLoginService, TicketService ticketService, BookingDetailRepository bookingDetailRepository, DateBean dateBean) {
        this.bookingRepository = bookingRepository;
        this.userLoginService = userLoginService;
        this.ticketService = ticketService;
        this.bookingDetailRepository = bookingDetailRepository;
        this.dateBean = dateBean;
    }

    public boolean addBooking(String userID, String date, String time, String cinemaRoomName, String seatName, String movieID) {
        // Tìm ID lớn nhất
        List<Booking> bookings = bookingRepository.findAll();
        int maxId = bookings.stream()
                .mapToInt(u -> Integer.parseInt(u.getBookingID().replaceAll("[^0-9]", "")))
                .max()
                .orElse(0);


        String newBookingId = "bk" + (maxId + 1);

        // 1. Tạo booking trước, chưa có ticket
        Booking booking = new Booking();
        booking.setBookingID(newBookingId);
        booking.setUserLogin(userLoginService.getUserByUserID(userID));
        booking.setTickets(new ArrayList<>()); // tạm set rỗng

        // 2. Lưu booking trước để Hibernate biết
        bookingRepository.save(booking);

        // 3. Sau khi booking đã tồn tại trong DB, mới tạo Ticket
        Ticket ticket = ticketService.addTicket(booking, date, time, cinemaRoomName, seatName, movieID);
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        // 4. Gán lại ticket list cho booking (nếu cần)
        booking.setTickets(ticketList);
        bookingRepository.save(booking); // Optional: update lại booking nếu mappedBy không tự động




        // Tạo booking detail
        BookingDetail detail = new BookingDetail();
        detail.setBookingDetailID("bkdt" + (maxId + 1)); // ví dụ tạo ID detail
        detail.setBooking(booking); // Gán booking vừa tạo
        detail.setBookingDate(dateBean.formatDate(dateBean.currentDate));
        detail.setTotalTicket(ticketList.size());

        System.out.println(detail.getBookingDetailID());

        bookingDetailRepository.save(detail);
        return true;
    }
}
