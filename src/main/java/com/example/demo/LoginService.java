package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserRepository userRepository;


    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> checkUser(User user) {
        HttpHeaders headers = new HttpHeaders();
        User findUser = userRepository.findById(user.getLogin()).orElse(null);
        if (findUser != null) {
            headers.add("Location", AppConstants.LOGIN_PAGE_PATH);
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }
        headers.add("Location", AppConstants.LOGIN_PAGE_PATH);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
