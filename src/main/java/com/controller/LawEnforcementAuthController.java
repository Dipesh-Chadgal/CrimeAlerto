package com.controller;

import com.dto.LawEnforcementDTO.LawEnforcementLogin;
import com.dto.LawEnforcementDTO.LawEnforcementRegister;
import com.service.LawEnforcementService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/lawEnforcement")
public class LawEnforcementAuthController {
    private final LawEnforcementService lawEnforcementService;

    public LawEnforcementAuthController(LawEnforcementService lawEnforcementService) {
        this.lawEnforcementService = lawEnforcementService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LawEnforcementRegister lawEnforcementRegister) {
        lawEnforcementService.register(lawEnforcementRegister);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LawEnforcementLogin lawEnforcementLogin, HttpServletResponse response) {
        if (lawEnforcementLogin.getEmail() == null) {
            return ResponseEntity.badRequest().body("Email is missing in the request");
        }
        String token = lawEnforcementService.login(lawEnforcementLogin);
         Cookie cookie = new Cookie("auth_token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(10*60*60);
        response.addCookie(cookie);
        return ResponseEntity.ok("Login successfull. Redirecting to LawEnforcement Portal. "+ token);
    }

}
