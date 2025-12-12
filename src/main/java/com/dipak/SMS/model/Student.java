package com.dipak.SMS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    private String firstName;
    private String lastName;

    @Id
    private String email;

    private String phone;
    private String gender;
    private Integer age;

    private String course;
    private String department;

    private LocalDate admissionDate;

    @PrePersist
    protected void onCreate() {
        this.admissionDate = LocalDate.now();
    }

    private String password;
}
