package com.controller;

import com.Tokens.CommonJwtUtil;
import com.dto.LawEnforcementDTO.LawEnforcementLogin;
import com.dto.LawEnforcementDTO.LawEnforcementRegister;
import com.entity.LawEnforcement;
import com.service.LawEnforcementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/lawEnforcement")
public class LawEnforcementAuthController {
    private final LawEnforcementService lawEnforcementService;
    private final CommonJwtUtil jwtUtil;

    public LawEnforcementAuthController(LawEnforcementService lawEnforcementService, CommonJwtUtil jwtUtil) {
        this.lawEnforcementService = lawEnforcementService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LawEnforcementRegister lawEnforcementRegister) {
        LawEnforcement lawEnforcement = lawEnforcementService.register(lawEnforcementRegister);
        String token = jwtUtil.generateToken(lawEnforcement.getPoliceStationEmail());
        return ResponseEntity.ok("User registered successfully. Token : " + token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LawEnforcementLogin lawEnforcementLogin) {
        if (lawEnforcementLogin.getEmail() == null) {
            return ResponseEntity.badRequest().body("Email is missing in the request");
        }
        String token = lawEnforcementService.login(lawEnforcementLogin);
        return ResponseEntity.ok("Login successfull, Token : " + token);
    }

}
