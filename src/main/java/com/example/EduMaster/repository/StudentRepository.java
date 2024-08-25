package com.example.EduMaster.repository;

import com.example.EduMaster.dto.StudentDTO;
import com.example.EduMaster.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
}
