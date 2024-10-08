package com.example.EduMaster.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Setter
@Getter
public class CourseDTO {
    private Long id;

    private String name;

    private String description;

    private Long instructorId;

    private int duration;

    private Date startDate;
}
