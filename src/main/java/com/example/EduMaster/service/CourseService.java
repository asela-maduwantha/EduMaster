package com.example.EduMaster.service;

import com.example.EduMaster.dto.CourseDTO;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    CourseDTO saveCourse(@Validated CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();

    Optional<CourseDTO> getCourseById(Long id);

    void deleteCourseById(Long id);

}
