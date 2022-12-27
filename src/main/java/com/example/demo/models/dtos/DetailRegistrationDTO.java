package com.example.demo.models.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailRegistrationDTO {

    private Integer idRegistrationDetail;

    @NotNull
    private CourseDTO course;

    @JsonBackReference
    private RegistrationDTO registration;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 50)
    private String classroom;
}
