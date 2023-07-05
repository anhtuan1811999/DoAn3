package com.example.doan3.service;

import com.example.doan3.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public boolean checkLogin(String email, String password){
        AtomicBoolean b = new AtomicBoolean(false);
        staffRepository.findAll().forEach(e -> {
            if (e.getEmail().equals(email)&e.getPassword().equals(password)){
                b.set(true);
            }
        });
        return b.get();
    }
}
