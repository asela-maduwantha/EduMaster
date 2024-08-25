package com.example.EduMaster.service.impl;

import com.example.EduMaster.entity.User;
import com.example.EduMaster.repository.UserRepository;
import com.example.EduMaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
