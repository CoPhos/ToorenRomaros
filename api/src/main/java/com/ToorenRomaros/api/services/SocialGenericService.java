package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.socials.SocialDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;

public interface SocialGenericService {
    public SocialGenericDto createSocialGeneric(SocialGenericAddRequestDto socialGenericAddRequestDto);
    public SocialGenericDto getSocialGenericbyGenericName(String genericName);
    public SocialGenericDto updateSocialGeneric(SocialDto socialDto);
    public void deleteSocialGenericByNames(String genericName, String socialName);
}
