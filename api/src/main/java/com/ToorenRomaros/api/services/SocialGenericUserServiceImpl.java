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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("SocialGenericUserServiceImpl")
public class SocialGenericUserServiceImpl implements SocialGenericService {

    private final SocialUserRepository socialUserRepository;
    private final SocialRepository socialRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private static final Logger log = LoggerFactory.getLogger(SocialGenericUserServiceImpl.class);

    public SocialGenericUserServiceImpl(SocialUserRepository socialUserRepository, SocialRepository socialRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.socialUserRepository = socialUserRepository;
        this.socialRepository = socialRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public SocialGenericDto createSocialGeneric(SocialGenericAddRequestDto socialGenericAddRequestDto, String username) {
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
    public List<SocialGenericDto> getSocialGenericById(UUID id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        List<SocialUserEntity> socialUserEntities = socialUserRepository.findSocialByUserId(userEntity.getId().toString());
        return socialUserEntities.stream().map(socialUserEntity -> {
            return modelMapper.map(socialUserEntity, SocialGenericDto.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public SocialGenericDto updateSocialGeneric(UUID id, SocialGenericAddRequestDto socialGenericAddRequestDto, String username) {
        SocialUserEntity socialUserEntity = socialUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));

        if (socialGenericAddRequestDto.getGenericId() != null) {
            UUID staffId = UUID.fromString(socialGenericAddRequestDto.getGenericId());
            UserEntity userEntity = userRepository.findById(staffId).orElseThrow(() -> new ResourceNotFoundException("'" + staffId + "'"));
            socialUserEntity.setUser(userEntity);
        }
        if (socialGenericAddRequestDto.getSocialId() != null) {
            UUID socialId = UUID.fromString(socialGenericAddRequestDto.getSocialId());
            SocialEntity socialEntity = socialRepository.findById(socialId).orElseThrow(() -> new ResourceNotFoundException("'" + socialId + "'"));
            socialUserEntity.setSocial(socialEntity);
        }
        if (socialGenericAddRequestDto.getUrl() != null) {
            String url = socialGenericAddRequestDto.getUrl();
            socialUserEntity.setUrl(url);
        }

        SocialUserEntity savedSocialUserEntity = socialUserRepository.save(socialUserEntity);
        return modelMapper.map(savedSocialUserEntity, SocialGenericDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator') || #username == authentication.name")
    @Override
    public void deleteSocialGenericById(UUID id, String username) {
        socialUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        socialUserRepository.deleteById(id);
    }
}
