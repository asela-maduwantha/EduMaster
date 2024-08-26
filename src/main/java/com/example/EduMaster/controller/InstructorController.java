package com.example.EduMaster.controller;

import com.example.EduMaster.dto.InstructorDTO;
import com.example.EduMaster.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.PreferencesEvent;
import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping("/create")
    public ResponseEntity<InstructorDTO> createInstructor(@Validated @RequestBody InstructorDTO instructorDTO){
       InstructorDTO createdInstructor = instructorService.saveInstructor(instructorDTO);
       return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }

    @GetMapping("/getAllInstructors")
    public ResponseEntity<List<InstructorDTO>> getAllInstructors(){
        List <InstructorDTO> instructors = instructorService.getAllInstructors();
        if(instructors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(instructors, HttpStatus.OK);
        }

    }

    @GetMapping("/getInstructorById/{id}")
    public ResponseEntity <InstructorDTO> getInstructorById(@PathVariable Long id){
        return instructorService.getInstructorById(id).map(InstructorDTO-> new ResponseEntity<>(InstructorDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @DeleteMapping("/deleteInstructorById/{id}")
    public ResponseEntity<Void> deleteInstructorById(@PathVariable Long id){
        if(instructorService.getInstructorById(id).isPresent()){
            instructorService.deleteInstructorById(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
