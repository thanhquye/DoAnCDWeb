package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginDAO {
    @Autowired
    public UserLoginService userLoginService;

    public void all(){
        boolean checkEmailExits = userLoginService.checkEmailExits("Email");
        UserLogin getUserbyEmailAndPassword = userLoginService.getUserbyEmailAndPassword("Email", "Password");
        List<UserLogin> getAll =  userLoginService.getAllUserLogins();
        List<UserLogin> getByName = userLoginService.getAllUserByName("Name");


    }
}
