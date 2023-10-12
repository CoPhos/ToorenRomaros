package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.socials.SocialDto;
import com.ToorenRomaros.api.dto.staff.StaffDto;
import com.ToorenRomaros.api.entities.socials.SocialEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.socials.SocialRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SocialServiceImpl implements SocialService{

    private final SocialRepository socialRepository;
    private final ModelMapper modelMapper;

    public SocialServiceImpl(SocialRepository socialRepository, ModelMapper modelMapper) {
        this.socialRepository = socialRepository;
        this.modelMapper = modelMapper;
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public SocialDto createSocial(SocialDto socialDto) {
        SocialEntity newSocial = modelMapper.map(socialDto, SocialEntity.class);
        SocialEntity savedSocial = socialRepository.save(newSocial);
        return modelMapper.map(savedSocial, SocialDto.class);
    }
    @Override
    public SocialDto getSocialById(UUID id) {
        SocialEntity socialEntity = socialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        return modelMapper.map(socialEntity, SocialDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public SocialDto updateSocial(UUID id, SocialDto socialDto) {
        SocialEntity newSocial = socialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        SocialEntity newData = modelMapper.map(socialRepository, SocialEntity.class);

        BeanUtils.copyProperties(newData, newSocial, Utils.getNullPropertyNames(newData));

        SocialEntity savedSocial = socialRepository.save(newSocial);
        return modelMapper.map(savedSocial, SocialDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public void deleteSocialByid(UUID id) {
        SocialEntity socialEntity = socialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        socialRepository.delete(socialEntity);
    }
}
