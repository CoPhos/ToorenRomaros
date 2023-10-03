package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.socials.SocialAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;

public interface SocialService {



    public SocialGenericDto createSocialStaff(SocialGenericAddRequestDto socialGenericAddRequestDto);
    public SocialGenericDto getSocialGenericbyGenericName(String genericName);
    public SocialGenericDto updateSocialGeneric(SocialAddRequestDto socialAddRequestDto);
    public void deleteSocialGenericByNames(String genericName, String socialName);
}
