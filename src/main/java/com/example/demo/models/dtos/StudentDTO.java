package com.example.demo.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    @Min(value = 1)
    private Integer idStudent;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 100)
    private String names;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 100)
    private String surnames;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 10)
    private String document;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer age;

}
