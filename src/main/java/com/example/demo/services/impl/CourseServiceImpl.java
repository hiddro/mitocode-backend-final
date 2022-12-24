package com.example.demo.services.impl;

import com.example.demo.models.entities.Course;
import com.example.demo.repository.CourseRepositories;
import com.example.demo.repository.GENERICRepositories;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends CRUDServiceImpl<Course, Integer> implements CourseService {

    @Autowired
    private CourseRepositories courseRepositories;

    @Override
    protected GENERICRepositories<Course, Integer> getRepo() {
        return courseRepositories;
    }
}
