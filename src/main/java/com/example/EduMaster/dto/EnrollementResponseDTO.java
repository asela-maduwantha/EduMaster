package com.example.EduMaster.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EnrollementResponseDTO {
    private Long id;
    private Date enrolledDate;
    private StudentDTO student;
    private CourseResponseDTO course;

}
