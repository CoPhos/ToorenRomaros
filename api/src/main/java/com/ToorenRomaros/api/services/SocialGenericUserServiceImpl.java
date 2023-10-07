package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.socials.SocialDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import com.ToorenRomaros.api.entities.socials.SocialEntity;
import com.ToorenRomaros.api.entities.socials.SocialStaffEntity;
import com.ToorenRomaros.api.entities.socials.SocialUserEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.socials.SocialRepository;
import com.ToorenRomaros.api.repositories.socials.SocialUserRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("SocialGenericUserServiceImpl")
public class SocialGenericUserServiceImpl implements SocialGenericService{

    private final SocialUserRepository socialUserRepository;
    private final SocialRepository socialRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public SocialGenericUserServiceImpl(SocialUserRepository socialUserRepository, SocialRepository socialRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.socialUserRepository = socialUserRepository;
        this.socialRepository = socialRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SocialGenericDto createSocialGeneric(SocialGenericAddRequestDto socialGenericAddRequestDto) {
        UUID socialId = UUID.fromString(socialGenericAddRequestDto.getSocialId());
        UUID userId = UUID.fromString(socialGenericAddRequestDto.getGenericId());
        String url = socialGenericAddRequestDto.getUrl();

        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("'" + userId + "'"));
        SocialEntity socialEntity = socialRepository.findById(socialId).orElseThrow(() -> new ResourceNotFoundException("'" + socialId + "'"));

        SocialUserEntity newSocialUserEntity = new SocialUserEntity(url, userEntity, socialEntity);
        SocialUserEntity savedSocialUserEntity = socialUserRepository.save(newSocialUserEntity);

        return modelMapper.map(savedSocialUserEntity, SocialGenericDto.class);
    }

    @Override
    public SocialGenericDto getSocialGenericbyGenericName(String genericName) {
        return null;
    }

    @Override
    public SocialGenericDto updateSocialGeneric(SocialDto socialDto) {
        return null;
    }

    @Override
    public void deleteSocialGenericByNames(String genericName, String socialName) {

    }
}
