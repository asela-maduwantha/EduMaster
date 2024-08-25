package com.example.EduMaster.service.impl;


import com.example.EduMaster.dto.StudentDTO;
import com.example.EduMaster.entity.Student;
import com.example.EduMaster.repository.StudentRepository;
import com.example.EduMaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private Student convertToEntity(StudentDTO studentDTO){
        Student student  = new Student();
        student.setEmail(studentDTO.getEmail());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(student.getLastName());
        student.setPassword(studentDTO.getPassword());
        student.setRole("Student");
        return student;
    }


    private StudentDTO convertToDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setGrade(student.getGrade());
        return studentDTO;
    }
    @Override
    public StudentDTO saveStudent(@Validated StudentDTO studentDTO){
        Student student = convertToEntity(studentDTO);
        student = studentRepository.save(student);
        return convertToDTO(student);

    }



    @Override
    public List <StudentDTO> getAllStudents(){
        return studentRepository.findAll().stream()
                .map(this :: convertToDTO).toList();
    }

    @Override
    public Optional <StudentDTO> getStudentById(Long id){
        return studentRepository.findById(id).map(this ::convertToDTO);
    }

    @Override
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

}
