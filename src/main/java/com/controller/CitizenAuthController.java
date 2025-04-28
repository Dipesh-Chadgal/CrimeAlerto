package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.dto.CitizenDTO.CitizenLogin;
import com.dto.CitizenDTO.CitizenRegister;
import com.service.CitizenService;
import com.entity.Citizen;

public class CitizenAuthController {
    private CitizenService citizenService;
    public CitizenAuthController(CitizenService citizenService){
        this.citizenService=citizenService;
    }

    public ResponseEntity<String> register(@RequestBody CitizenRegister citizenRegister){
        Citizen citizen=citizenService.register(citizenRegister);
        return ResponseEntity.ok("User registered successfully");
    }

    public ResponseEntity<String> login(@RequestBody CitizenLogin CitizenLogin){
        String token=citizenService.login(CitizenLogin);
        return ResponseEntity.ok("Login successfull, token "+ token);
    }

}
