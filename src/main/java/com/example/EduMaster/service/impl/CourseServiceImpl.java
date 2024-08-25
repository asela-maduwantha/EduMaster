package com.example.EduMaster.service.impl;

import com.example.EduMaster.dto.CourseDTO;
import com.example.EduMaster.entity.Course;
import com.example.EduMaster.repository.CourseRepository;
import com.example.EduMaster.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    private Course convertToEntity(@Validated CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setInstructor(courseDTO.getInstructor());
        course.setDuration(courseDTO.getDuration());
        course.setStartDate(courseDTO.getStartDate());
        return course;
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setInstructor(course.getInstructor());
        courseDTO.setDuration(course.getDuration());
        courseDTO.setStartDate(course.getStartDate());
        return courseDTO;
    }


    //creat new course
    @Override
    public CourseDTO saveCourse(@Validated CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        course = courseRepository.save(course);
        return convertToDTO(course);
    }

    //get all courses
    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    //get course by id
    @Override
    public Optional<CourseDTO> getCourseById(Long id){
        return courseRepository.findById(id)
                .map(this::convertToDTO);
    }

    //delete course by id
    @Override
    public void deleteCourseById(Long id){
        courseRepository.deleteById(id);
    }
}


