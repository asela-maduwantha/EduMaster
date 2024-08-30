package com.example.EduMaster.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EnrollmentDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private Date enrolledDate;
}
