package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.staff.CreateStaffDto;
import com.ToorenRomaros.api.dto.staff.GetStaffDto;
import com.ToorenRomaros.api.dto.staff.UpdateStaffDto;

import java.util.UUID;

public interface StaffService {
    public GetStaffDto createStaff(CreateStaffDto staffAddRequestDto);
    public GetStaffDto getStaffById(UUID id);
    public GetStaffDto updateStaff(UUID id, UpdateStaffDto staffAddRequestDto);
    public void deleteStaffByid(UUID id);
}
