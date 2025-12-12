package com.dipak.SMS.controller;

import com.dipak.SMS.model.Admin;
import com.dipak.SMS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/register")
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin){
        service.addAdmin(admin);
        return ResponseEntity.ok("Admin Added Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin admin) {

        String result = service.login(admin);

        if (result.equals("Login Successful...")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
