package com.example.EduMaster.service;

import com.example.EduMaster.dto.InstructorDTO;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    InstructorDTO saveInstructor(@Validated InstructorDTO instructorDTO);

    List <InstructorDTO> getAllInstructors();

    Optional <InstructorDTO> getInstructorById(Long id);

    void deleteInstructorById(Long id);
}
