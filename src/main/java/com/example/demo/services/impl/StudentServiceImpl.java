package com.example.demo.services.impl;

import com.example.demo.models.entities.Student;
import com.example.demo.repository.GENERICRepositories;
import com.example.demo.repository.StudentRepositories;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends CRUDServiceImpl<Student, Integer> implements StudentService {

    @Autowired
    private StudentRepositories studentRepositories;

    @Override
    protected GENERICRepositories<Student, Integer> getRepo() {
        return studentRepositories;
    }
}
