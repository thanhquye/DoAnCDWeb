package com.example.Movie_Ticket_Website.utils;

import java.util.Random;

public class PasswordGenerator {
    public static String generateRandomPassword(int length) {
        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            int index = rnd.nextInt(charSet.length());
            password.append(charSet.charAt(index));
        }
        return password.toString();
    }
}