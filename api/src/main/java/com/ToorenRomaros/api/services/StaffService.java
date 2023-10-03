package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.socials.SocialAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import com.ToorenRomaros.api.dto.staff.StaffAddRequestDto;
import com.ToorenRomaros.api.dto.staff.StaffDto;

import java.util.UUID;

public interface StaffService {
    public StaffDto createStaff(StaffAddRequestDto staffAddRequestDto);
    public StaffDto getStaffById(UUID id);
    public StaffDto updateStaff(UUID id, StaffAddRequestDto staffAddRequestDto);
    public void deleteStaffByid(UUID id);


}
