package com.example.EduMaster.controller;

import com.example.EduMaster.dto.StudentDTO;
import com.example.EduMaster.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity <StudentDTO> createStudent(@Validated @RequestBody StudentDTO studentDTO){
        StudentDTO createdStudent = studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List <StudentDTO> students  = studentService.getAllStudents();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity <StudentDTO> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id)
                .map(StudentDTO -> new ResponseEntity<>(StudentDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity <Void> deleteStudentById(@PathVariable Long id){
        if(studentService.getStudentById(id).isPresent()){
            studentService.deleteStudentById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
