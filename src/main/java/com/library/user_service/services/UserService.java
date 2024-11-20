package com.library.user_service.services;

import com.library.user_service.entities.User;
import com.library.user_service.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private static final String BOOK_SERVICE_URL = "http://localhost:8082/books/user/";


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(int userId) {
        return userRepo.findById(userId);
    }

    public List<String> getBooksHeldByUser(int userId) {
        String url = BOOK_SERVICE_URL + userId;
        return restTemplate.getForObject(url, List.class);
    }
}
