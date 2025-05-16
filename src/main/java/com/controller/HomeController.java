package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> createComplaint(@RequestBody ComplaintDTO complaint){
        return ResponseEntity.ok("ok");
    }
}
