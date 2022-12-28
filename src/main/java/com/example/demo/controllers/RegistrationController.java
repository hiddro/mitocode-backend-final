package com.example.demo.controllers;

import com.example.demo.models.dtos.RegistrationDTO;
import com.example.demo.models.dtos.ResponseGroup;
import com.example.demo.models.dtos.StudentDTO;
import com.example.demo.models.entities.Registration;
import com.example.demo.models.entities.Student;
import com.example.demo.services.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RegistrationDTO>> readAll() throws Exception{
        List<RegistrationDTO> list = registrationService.findAll()
                .stream()
                .map(registration -> modelMapper.map(registration, RegistrationDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistrationDTO> save(@Valid @RequestBody RegistrationDTO registrationDTO) throws Exception{
        Registration registration = registrationService.save(modelMapper.map(registrationDTO, Registration.class));

        return new ResponseEntity<>(modelMapper.map(registration, RegistrationDTO.class), HttpStatus.CREATED);
    }

    @GetMapping("/group")
    public ResponseEntity<?> groupStudent() throws Exception{

        Map<String, List<ResponseGroup>> list = registrationService.findAll()
                .stream()
                .map(registration -> {
                    return new ResponseGroup(registration.getDetailRegList().get(0).getCourse().getName(), registration.getStudent().getNames());
                })
                .collect(Collectors.groupingBy(ResponseGroup::getNameCourse));


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
