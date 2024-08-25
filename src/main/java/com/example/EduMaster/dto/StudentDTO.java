package com.example.EduMaster.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private double grade;
}
