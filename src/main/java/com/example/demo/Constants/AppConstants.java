package com.example.demo.Constants;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.management.ConstructorParameters;

@NoArgsConstructor
@Getter
public class AppConstants {
    public static final String REGISTRATION_PAGE_PATH = "/registration";
    public static final String LOGIN_PAGE_PATH = "/login";
    public static final String HTML_FILE_REGISTRATION = "registration";
    public static final String HTML_FILE_LOGIN = "login";
    public static final String DATABASE_PAGE_PATH = "/h2-console/**";
}
