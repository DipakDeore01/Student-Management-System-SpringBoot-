package com.dipak.SMS.repository;

import com.dipak.SMS.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, String> {
    Student findByEmail(String email);

    List<Student> findByDepartment(String department);

    List<Student> findByCourse(String course);

    List<Student> findByYear(int year);

    boolean existsByEmail(String email);
}
