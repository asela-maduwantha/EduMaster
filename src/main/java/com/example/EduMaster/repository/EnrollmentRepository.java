package com.example.EduMaster.repository;


import com.example.EduMaster.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository <Enrollment, Long> {
    List <Enrollment> findByStudentId(Long studentId);

    List <Enrollment> findByCourseId(Long courseId);
}
