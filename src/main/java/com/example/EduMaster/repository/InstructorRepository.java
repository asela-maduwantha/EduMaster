package com.example.EduMaster.repository;

import com.example.EduMaster.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository <Instructor, Long> {

}
