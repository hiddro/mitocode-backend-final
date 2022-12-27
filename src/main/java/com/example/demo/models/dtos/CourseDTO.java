package com.example.demo.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    @Min(value = 1)
    private Integer idCourse;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 100)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 4)
    private String acronym;

    @NotNull
    private Boolean state;
}
