package com.example.Movie_Ticket_Website.service.admin;

import com.example.Movie_Ticket_Website.dto.FilmEarning;
import com.example.Movie_Ticket_Website.repository.MovieRepository;
import com.example.Movie_Ticket_Website.repository.TicketDetailRepository;
import com.example.Movie_Ticket_Website.repository.TicketRepository;
import com.example.Movie_Ticket_Website.repository.UserLoginRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDashboardService {

    @Autowired
    private UserLoginRepository userRepo;

    @Autowired
    private TicketRepository ticketRepo;

    @Autowired
    private TicketDetailRepository ticketDetailRepo;

    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    private EntityManager entityManager;

    public long countOnlineUsers() {
        return userRepo.countByIsActiveTrueAndIsAdminFalse();
    }

    public long countTickets() {
        return ticketRepo.count();
    }

    public double totalEarning() {
        return ticketDetailRepo.findAll().stream()
                .mapToDouble(td -> td.getPrice())
                .sum();
    }

    public long totalMovies() {
        return movieRepo.count();
    }

    public List<FilmEarning> getTop10MovieEarnings() {
        String sql = """
                    SELECT new com.example.Movie_Ticket_Website.dto.FilmEarning(
                        m.movieID, m.movieName, m.movieCategory, m.releaseDate,
                        m.country, m.movieScore, CAST(SUM(td.price) AS double)
                    )
                    FROM TicketDetail td
                    JOIN td.ticket tk
                    JOIN tk.showTime st
                    JOIN st.movie m
                    GROUP BY m.movieID, m.movieName, m.movieCategory, m.releaseDate,
                             m.country, m.movieScore
                    ORDER BY SUM(td.price) DESC
                """;

        return entityManager.createQuery(sql, FilmEarning.class)
                .setMaxResults(10)
                .getResultList();
    }
}