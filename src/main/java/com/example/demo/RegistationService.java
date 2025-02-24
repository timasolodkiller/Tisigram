package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class RegistationService {
    private final UserRepository userRepository;

    @Autowired
    public RegistationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> checkPassword(User user) {
        HttpHeaders headers = new HttpHeaders();

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            headers.add("Location", AppConstants.REGISTRATION_PAGE_PATH);
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }
        userRepository.save(user);
        headers.add("Location", AppConstants.LOGIN_PAGE_PATH);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

}
