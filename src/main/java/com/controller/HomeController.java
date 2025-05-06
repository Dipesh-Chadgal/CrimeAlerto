package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.dto.ComplaintDTO;;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @GetMapping
    public String home() {
        return "Welcome to the Home Page!";
    }
    @GetMapping("/test")
    public String law(){
        return "law enforcement";
    }

    @PostMapping("/complaints")
    public ResponseEntity<String> createComplaint(@ResponseBody ComplaintDTO){
        
    }
}
