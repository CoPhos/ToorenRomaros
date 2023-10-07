package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.socials.SocialDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import com.ToorenRomaros.api.dto.staff.StaffDto;

import java.util.UUID;

public interface SocialService {
    public SocialDto createSocial(SocialDto socialDto);
    public SocialDto getSocialById(UUID id);
    public SocialDto updateSocial(UUID id, SocialDto socialDto);
    public void deleteSocialByid(UUID id);


}
