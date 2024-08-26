package com.example.EduMaster.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instructor")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor extends User{
    @Column
    private String nic;

    public Instructor(String email, String firstName, String lastName, String password, String role, String nic){
        super(email, firstName, lastName, password, role);
        this.nic = nic;
    }
}
