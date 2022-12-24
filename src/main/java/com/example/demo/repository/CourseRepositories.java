package com.example.demo.repository;

import com.example.demo.models.entities.Course;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepositories extends GENERICRepositories<Course, Integer> {
}
