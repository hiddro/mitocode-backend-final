package com.example.demo.controllers;

import com.example.demo.exceptions.ModelNotFoundException;
import com.example.demo.models.dtos.CourseDTO;
import com.example.demo.models.entities.Course;
import com.example.demo.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> readAll() throws Exception{
        List<CourseDTO> list = courseService.findAll()
                .stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable("id") Integer id) throws Exception{
        CourseDTO course = modelMapper.map(courseService.findById(id), CourseDTO.class);

        if(course == null){
            throw new ModelNotFoundException("ID Not Found: " + id);
        }

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO courseDTO) throws Exception{
        Course course = courseService.save(modelMapper.map(courseDTO, Course.class));

        return new ResponseEntity<>(modelMapper.map(course, CourseDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CourseDTO> update(@Valid @RequestBody CourseDTO courseDTO) throws Exception{
        Course course = courseService.update(modelMapper.map(courseDTO, Course.class));

        return new ResponseEntity<>(modelMapper.map(course, CourseDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Course course = courseService.findById(id);

        if(course == null){
            throw new ModelNotFoundException("ID Not Found: " + id);
        }

        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
