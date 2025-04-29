package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CitizenDTO.CitizenLogin;
import com.dto.CitizenDTO.CitizenRegister;
import com.service.CitizenService;
import com.entity.Citizen;
import com.Tokens.CitizenJwtUtil;

@RestController
@RequestMapping("/api/citizen")
public class CitizenAuthController {
    private CitizenService citizenService;
    private CitizenJwtUtil jwtUtil;
    public CitizenAuthController(CitizenService citizenService,CitizenJwtUtil jwtUtil) {
        this.citizenService = citizenService;
        this.jwtUtil=jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CitizenRegister citizenRegister) {
        Citizen citizen = citizenService.register(citizenRegister);
        String token = jwtUtil.generateToken(citizen.getEmail());
        return ResponseEntity.ok("User registered successfully. Token : " + token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CitizenLogin CitizenLogin) {
        String token = citizenService.login(CitizenLogin);
        return ResponseEntity.ok("Login successfull, Token : " + token);
    }

}
