package com.example.EduMaster.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="student")
public class Student extends User {

        @Column(nullable = true)
        private double grade;

        public Student(String email, String firstName, String lastName, String password, String role, double grade){
            super(email, firstName, lastName, password, role);
            this.grade = grade;
        }
}
