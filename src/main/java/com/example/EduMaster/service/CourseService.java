package com.example.EduMaster.service;

import com.example.EduMaster.dto.CourseDTO;
import com.example.EduMaster.dto.CourseResponseDTO;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    CourseResponseDTO saveCourse(@Validated CourseDTO courseDTO);

    List<CourseResponseDTO> getAllCourses();

    Optional<CourseResponseDTO> getCourseById(Long id);

    void deleteCourseById(Long id);

}
