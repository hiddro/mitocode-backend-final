package com.example.demo.repository;

import com.example.demo.models.entities.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositories extends GENERICRepositories<Student, Integer> {
}
