package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.staff.StaffDto;

import java.util.UUID;

public interface StaffService {
    public StaffDto createStaff(StaffDto staffAddRequestDto);
    public StaffDto getStaffById(UUID id);
    public StaffDto updateStaff(UUID id, StaffDto staffAddRequestDto);
    public void deleteStaffByid(UUID id);


}
