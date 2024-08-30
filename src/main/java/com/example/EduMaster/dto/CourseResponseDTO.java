package com.example.EduMaster.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class CourseResponseDTO {
    private Long id;

    private String name;

    private String description;

    private Long instructorId;

    private String instructorName;

    private int duration;

    private Date startDate;
}
