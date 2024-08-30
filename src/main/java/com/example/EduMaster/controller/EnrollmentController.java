package com.example.EduMaster.controller;

import com.example.EduMaster.dto.EnrollementResponseDTO;
import com.example.EduMaster.dto.EnrollmentDTO;
import com.example.EduMaster.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;


    @PostMapping("/create")
    public ResponseEntity<EnrollementResponseDTO> createEnrollment(@Validated @RequestBody  EnrollmentDTO enrollmentDTO){
        EnrollementResponseDTO createdEnrollment = enrollmentService.saveEnrollment(enrollmentDTO);
        return new ResponseEntity<>(createdEnrollment, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity <List<EnrollementResponseDTO>> getAllEnrollments(){
        List <EnrollementResponseDTO> enrollments = enrollmentService.getALlEnrollments();
        if (enrollments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/getByStudent/{studentId}")
    public ResponseEntity <List<EnrollementResponseDTO>> getEnrollmentsByStudent(@PathVariable Long studentId){
        List <EnrollementResponseDTO> enrollments = enrollmentService.getEnrollmentByStudentId(studentId);
        if (enrollments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/getByCourse/{courseId}")
    public ResponseEntity <List<EnrollementResponseDTO>> getEnrollmentsByCourse(@PathVariable Long courseId){
        List <EnrollementResponseDTO> enrollments = enrollmentService.getEnrollmentByStudentId(courseId);
        if (enrollments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Void> deleteEnrollment(@PathVariable Long id){

            enrollmentService.deleteEnrollmentById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


