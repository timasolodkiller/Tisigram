package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RestController {
    private final RegistationService registationService;

    @Autowired
    public RestController(Environment env, RegistationService registationService) {
        this.registationService = registationService;
    }

    @GetMapping(AppConstants.REGISTRATION_PAGE_PATH)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return AppConstants.HTML_FILE_REGISTRATION;
    }

    @PostMapping(AppConstants.REGISTRATION_PAGE_PATH)
    public ResponseEntity<String> processRegistration(@ModelAttribute("user") User user) {
        return registationService.checkPassword(user);
    }

    @GetMapping(AppConstants.LOGIN_PAGE_PATH)
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return AppConstants.HTML_FILE_LOGIN;
    }

    @PostMapping(AppConstants.LOGIN_PAGE_PATH)
    public ResponseEntity<String> processLogin(@ModelAttribute("user") User user) {
        return registationService.checkPassword(user);
    }
}
