package com.dipak.SMS.controller;

import com.dipak.SMS.model.Student;
import com.dipak.SMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/register")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        service.addStudent(student);
        return ResponseEntity.ok("Student Added Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Student student){
        String result = service.login(student);

        if (result.equals("Login Successful...")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
