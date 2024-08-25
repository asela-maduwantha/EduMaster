package com.example.EduMaster.controller;

import com.example.EduMaster.dto.CourseDTO;
import com.example.EduMaster.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCourse(@Validated @RequestBody CourseDTO courseDTO) {
        try {
            CourseDTO createdCourse = courseService.saveCourse(courseDTO);
            return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception (you can use a logger for real logging)
            String errorMessage = "Failed to create course. Error: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<Object> getAllCourses() {
        try {
            List<CourseDTO> courses = courseService.getAllCourses();
            if (courses.isEmpty()) {
                return new ResponseEntity<>("No courses found.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            String errorMessage = "Failed to retrieve courses. Error: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable int id) {
        try {
            Optional<CourseDTO> courseDTO = courseService.getCourseById(id);
            if (courseDTO.isPresent()) {
                return new ResponseEntity<>(courseDTO.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Course not found with ID: " + id, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception
            String errorMessage = "Failed to retrieve course with ID: " + id + ". Error: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCourseById/{id}")
    public ResponseEntity<Object> deleteCourseById(@PathVariable int id) {
        try {
            if (courseService.getCourseById(id).isPresent()) {
                courseService.deleteCourseById(id);
                return new ResponseEntity<>("Course deleted successfully.", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Course not found with ID: " + id, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception
            String errorMessage = "Failed to delete course with ID: " + id + ". Error: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
