package com.example.EduMaster.service.impl;

import com.example.EduMaster.dto.*;
import com.example.EduMaster.entity.Course;
import com.example.EduMaster.entity.Enrollment;
import com.example.EduMaster.entity.Student;
import com.example.EduMaster.repository.CourseRepository;
import com.example.EduMaster.repository.EnrollmentRepository;
import com.example.EduMaster.repository.StudentRepository;
import com.example.EduMaster.service.CourseService;
import com.example.EduMaster.service.EnrollmentService;
import com.example.EduMaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    private Enrollment convertToEntity(EnrollmentDTO enrollmentDTO){

        Student student = studentRepository.findById(enrollmentDTO.getStudentId()).orElse(null);
        Course course = courseRepository.findById(enrollmentDTO.getCourseId()).orElse(null);
        Enrollment enrollment = new Enrollment();
        enrollment.setId(enrollmentDTO.getId());
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrolledDate(enrollmentDTO.getEnrolledDate());
        return enrollment;
    }

    private EnrollementResponseDTO convertToDTO(Enrollment enrollment){
        EnrollementResponseDTO enrollementResponseDTO = new EnrollementResponseDTO();
        enrollementResponseDTO.setId(enrollment.getId());
        StudentDTO studentDTO = studentService.getStudentById(enrollment.getStudent().getId()).orElse(null);
        enrollementResponseDTO.setStudent(studentDTO);
        CourseResponseDTO courseResponseDTO = courseService.getCourseById(enrollment.getCourse().getId()).orElse(null);
        enrollementResponseDTO.setCourse(courseResponseDTO);
        enrollementResponseDTO.setEnrolledDate(enrollment.getEnrolledDate());
        return enrollementResponseDTO;
    }


    @Override
    public EnrollementResponseDTO saveEnrollment(@Validated EnrollmentDTO enrollmentDTO){
        Enrollment enrollment = convertToEntity(enrollmentDTO);
        enrollment = enrollmentRepository.save(enrollment);

        return convertToDTO(enrollment);
    }

    @Override
    public List<EnrollementResponseDTO> getALlEnrollments(){
        return enrollmentRepository.findAll().stream()
                .map(this:: convertToDTO).toList();
    }

    @Override
    public List <EnrollementResponseDTO> getEnrollmentByStudentId(Long id){
        return enrollmentRepository.findByStudentId(id).stream()
                .map(this:: convertToDTO).toList();
    }

    @Override
    public List <EnrollementResponseDTO> getEnrollmentByCourseId(Long id){
        return enrollmentRepository.findByCourseId(id).stream()
                .map(this:: convertToDTO).toList();
    }

    @Override
    public void deleteEnrollmentById(Long id){
        enrollmentRepository.deleteById(id);
    }

}
