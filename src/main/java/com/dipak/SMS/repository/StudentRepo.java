package com.dipak.SMS.repository;

import com.dipak.SMS.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, String> {
    Student findByEmail(String email);
}
