package com.example.EduMaster.service.impl;

import com.example.EduMaster.dto.InstructorDTO;
import com.example.EduMaster.entity.Instructor;
import com.example.EduMaster.repository.InstructorRepository;
import com.example.EduMaster.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    private Instructor convertToEntity(InstructorDTO instructorDTO){
        Instructor instructor = new Instructor();
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setFirstName(instructorDTO.getFirstName());
        instructor.setLastName(instructorDTO.getLastName());
        instructor.setPassword(instructorDTO.getPassword());
        instructor.setNic(instructorDTO.getNic());
        return instructor;
    }

    private InstructorDTO convertToDTO(Instructor instructor){
        InstructorDTO instructorDTO = new InstructorDTO();
        instructorDTO.setFirstName(instructor.getFirstName());
        instructorDTO.setLastName(instructor.getLastName());
        instructorDTO.setEmail(instructor.getEmail());
        instructorDTO.setNic(instructor.getNic());
        return instructorDTO;
    }

    @Override
    public InstructorDTO saveInstructor(@Validated InstructorDTO instructorDTO){
        Instructor instructor = convertToEntity(instructorDTO);
        instructor = instructorRepository.save(instructor);
        return convertToDTO(instructor);
    }

    @Override
    public List<InstructorDTO> getAllInstructors(){
        return instructorRepository.findAll().stream()
                .map(this::convertToDTO).toList();
    }

    @Override
    public Optional<InstructorDTO> getInstructorById(Long id) {
        return instructorRepository.findById(id).map(this::convertToDTO);
    }

   @Override
    public void deleteInstructorById(Long id){
        instructorRepository.deleteById(id);
   }
}

