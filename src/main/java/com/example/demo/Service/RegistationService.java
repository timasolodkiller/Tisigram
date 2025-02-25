package com.example.demo.Service;

import com.example.demo.Constants.AppConstants;
import com.example.demo.DTO.RegistrationResponse;
import com.example.demo.DTO.User;
import com.example.demo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class RegistationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public ResponseEntity<RegistrationResponse> checkPassword(User user) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            RegistrationResponse response = new RegistrationResponse(
                    "Пароли не совпадают",
                    "400",
                    AppConstants.REGISTRATION_PAGE_PATH
            );
            return ResponseEntity.badRequest().body(response);
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        RegistrationResponse response = new RegistrationResponse(
                "Успешная регистрация",
                "200",
                AppConstants.LOGIN_PAGE_PATH
        );
        return ResponseEntity.ok(response);
    }


}
