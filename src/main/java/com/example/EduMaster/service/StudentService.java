package com.example.EduMaster.service;

import com.example.EduMaster.dto.StudentDTO;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO saveStudent(@Validated StudentDTO studentDTO);

    List <StudentDTO> getAllStudents();

    Optional <StudentDTO> getStudentById(Long id);

    void deleteStudentById(Long id);
}
