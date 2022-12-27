package com.example.demo.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDTO {

    private Integer idRegistration;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private StudentDTO student;

    @NotNull
    @JsonManagedReference
    private List<DetailRegistrationDTO> detailRegList;

    @NotNull
    private Boolean state;
}
