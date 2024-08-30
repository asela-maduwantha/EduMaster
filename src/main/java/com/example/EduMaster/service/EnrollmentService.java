package com.example.EduMaster.service;

import com.example.EduMaster.dto.EnrollementResponseDTO;
import com.example.EduMaster.dto.EnrollmentDTO;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    EnrollementResponseDTO saveEnrollment(@Validated EnrollmentDTO enrollmentDTO);

    List <EnrollementResponseDTO> getALlEnrollments();

    List <EnrollementResponseDTO> getEnrollmentByStudentId(Long id);

    List <EnrollementResponseDTO> getEnrollmentByCourseId(Long id);

    void deleteEnrollmentById(Long id);
}
