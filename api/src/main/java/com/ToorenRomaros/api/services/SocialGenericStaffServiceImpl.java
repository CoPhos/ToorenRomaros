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

import java.util.UUID;

@Service("SocialGenericStaffServiceImpl")
public class SocialGenericStaffServiceImpl implements SocialGenericService{
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
