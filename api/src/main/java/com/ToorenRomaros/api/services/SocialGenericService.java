package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.socials.SocialDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;

import java.util.List;
import java.util.UUID;

public interface SocialGenericService {
    public SocialGenericDto createSocialGeneric(SocialGenericAddRequestDto socialGenericAddRequestDto, String username);
    public List<SocialGenericDto> getSocialGenericById(UUID id);
    public SocialGenericDto updateSocialGeneric(UUID id, SocialGenericAddRequestDto socialGenericAddRequestDto, String username);
    public void deleteSocialGenericById(UUID id, String username);
}
