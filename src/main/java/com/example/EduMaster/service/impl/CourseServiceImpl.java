package com.example.EduMaster.service.impl;

import com.example.EduMaster.dto.CourseDTO;
import com.example.EduMaster.dto.CourseResponseDTO;
import com.example.EduMaster.entity.Course;
import com.example.EduMaster.entity.Instructor;
import com.example.EduMaster.repository.CourseRepository;
import com.example.EduMaster.repository.InstructorRepository;
import com.example.EduMaster.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    private Course convertToEntity(@Validated CourseDTO courseDTO) {
        Instructor instructor = instructorRepository.findById(courseDTO.getInstructorId()).orElse(null);
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setInstructor(instructor);
        course.setDuration(courseDTO.getDuration());
        course.setStartDate(courseDTO.getStartDate());
        return course;
    }

    private CourseResponseDTO convertToDTO(Course course) {
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setId(course.getId());
        courseResponseDTO.setName(course.getName());
        courseResponseDTO.setDescription(course.getDescription());
        courseResponseDTO.setInstructorId(course.getInstructor().getId());
        courseResponseDTO.setInstructorName(Objects.requireNonNull(instructorRepository.findById(course.getInstructor().getId()).orElse(null)).getFirstName());
        courseResponseDTO.setDuration(course.getDuration());
        courseResponseDTO.setStartDate(course.getStartDate());
        return courseResponseDTO;
    }


    //creat new course
    @Override
    public CourseResponseDTO saveCourse(@Validated CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        course = courseRepository.save(course);
        return convertToDTO(course);
    }

    //get all courses
    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    //get course by id
    @Override
    public Optional<CourseResponseDTO> getCourseById(Long id){
        return courseRepository.findById(id)
                .map(this::convertToDTO);
    }

    //delete course by id
    @Override
    public void deleteCourseById(Long id){
        courseRepository.deleteById(id);
    }
}


