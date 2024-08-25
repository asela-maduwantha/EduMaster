package com.example.EduMaster.service;

import com.example.EduMaster.entity.User;

import java.util.Optional;


public interface UserService {
    Optional <User> getUserByEmail(String email);
}
