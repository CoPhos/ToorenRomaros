package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.Staff;
import com.ToorenRomaros.api.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public void saveStaff(Staff staff){
        staffRepository.save(staff);
    }

    public void deleteStaff(UUID id){
        staffRepository.deleteById(id);
    }
}
