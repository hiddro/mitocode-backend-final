package com.example.demo.controllers;

import com.example.demo.exceptions.ModelNotFoundException;
import com.example.demo.models.dtos.StudentDTO;
import com.example.demo.models.entities.Student;
import com.example.demo.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> list = studentService.findAll()
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable("id") Integer id) throws Exception{
        StudentDTO student = modelMapper.map(studentService.findById(id), StudentDTO.class);

        if(student == null){
            throw new ModelNotFoundException("ID Not Found: " + id);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO studentDTO) throws Exception{
        Student student = studentService.save(modelMapper.map(studentDTO, Student.class));

        return new ResponseEntity<>(modelMapper.map(student, StudentDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO studentDTO) throws Exception{
        Student student = studentService.update(modelMapper.map(studentDTO, Student.class));

        return new ResponseEntity<>(modelMapper.map(student, StudentDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Student student = studentService.findById(id);

        if(student == null){
            throw new ModelNotFoundException("ID Not Found: " + id);
        }

        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
