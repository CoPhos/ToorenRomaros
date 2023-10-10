package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.socials.SocialDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericAddRequestDto;
import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import com.ToorenRomaros.api.entities.socials.SocialEntity;
import com.ToorenRomaros.api.entities.socials.SocialStaffEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.socials.SocialRepository;
import com.ToorenRomaros.api.repositories.socials.SocialStaffRepository;
import com.ToorenRomaros.api.repositories.staff.StaffRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("SocialGenericStaffServiceImpl")
public class SocialGenericStaffServiceImpl implements SocialGenericService {
    private final SocialStaffRepository socialStaffRepository;
    private final StaffRepository staffRepository;
    private final SocialRepository socialRepository;
    private final ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(SocialGenericStaffServiceImpl.class);

    public SocialGenericStaffServiceImpl(SocialStaffRepository socialStaffRepository, StaffRepository staffRepository, SocialRepository socialRepository, ModelMapper modelMapper) {
        this.socialStaffRepository = socialStaffRepository;
        this.staffRepository = staffRepository;
        this.socialRepository = socialRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SocialGenericDto createSocialGeneric(SocialGenericAddRequestDto socialGenericAddRequestDto) {
        UUID socialId = UUID.fromString(socialGenericAddRequestDto.getSocialId());
        UUID staffId = UUID.fromString(socialGenericAddRequestDto.getGenericId());
        String url = socialGenericAddRequestDto.getUrl();

        StaffEntity staffEntity = staffRepository.findById(staffId).orElseThrow(() -> new ResourceNotFoundException("'" + staffId + "'"));
        SocialEntity socialEntity = socialRepository.findById(socialId).orElseThrow(() -> new ResourceNotFoundException("'" + socialId + "'"));

        SocialStaffEntity newSocialStaffEntity = new SocialStaffEntity(url, staffEntity, socialEntity);
        SocialStaffEntity savedSocialStaffEntity = socialStaffRepository.save(newSocialStaffEntity);

        return modelMapper.map(savedSocialStaffEntity, SocialGenericDto.class);
    }

    @Override
    public List<SocialGenericDto> getSocialGenericById(UUID id) {
        StaffEntity staffEntity = staffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        List<SocialStaffEntity> socialStaffEntities = socialStaffRepository.findSocialByStaffId(staffEntity.getId().toString());
        return socialStaffEntities.stream().map(socialStaffEntity -> {
            return modelMapper.map(socialStaffEntity, SocialGenericDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public SocialGenericDto updateSocialGeneric(UUID id, SocialGenericAddRequestDto socialGenericAddRequestDto) {
        SocialStaffEntity socialStaffEntity = socialStaffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));

        if (socialGenericAddRequestDto.getGenericId() != null) {
            UUID staffId = UUID.fromString(socialGenericAddRequestDto.getGenericId());
            StaffEntity staffEntity = staffRepository.findById(staffId).orElseThrow(() -> new ResourceNotFoundException("'" + staffId + "'"));
            socialStaffEntity.setStaff(staffEntity);
        }
        if (socialGenericAddRequestDto.getSocialId() != null) {
            UUID socialId = UUID.fromString(socialGenericAddRequestDto.getSocialId());
            SocialEntity socialEntity = socialRepository.findById(socialId).orElseThrow(() -> new ResourceNotFoundException("'" + socialId + "'"));
            socialStaffEntity.setSocial(socialEntity);
        }
        if (socialGenericAddRequestDto.getUrl() != null) {
            String url = socialGenericAddRequestDto.getUrl();
            socialStaffEntity.setUrl(url);
        }

        SocialStaffEntity savedSocialStaffEntity = socialStaffRepository.save(socialStaffEntity);
        return modelMapper.map(savedSocialStaffEntity, SocialGenericDto.class);
    }

    @Override
    public void deleteSocialGenericById(UUID id) {
        socialStaffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        socialStaffRepository.deleteById(id);
    }
}
