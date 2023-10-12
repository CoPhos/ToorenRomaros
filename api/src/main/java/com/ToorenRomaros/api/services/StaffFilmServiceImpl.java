package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.socials.SocialGenericDto;
import com.ToorenRomaros.api.dto.staff.StaffFilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.staff.StaffFilmRepository;
import com.ToorenRomaros.api.repositories.staff.StaffRepository;
import com.ToorenRomaros.api.utils.Utils;
import com.nimbusds.jose.crypto.impl.ECDH;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StaffFilmServiceImpl implements StaffFilmService {
    private final ModelMapper modelMapper;
    private final StaffFilmRepository staffFilmRepository;
    private final FilmRepository filmRepository;
    private final StaffRepository staffRepository;
    private static final Logger log = LoggerFactory.getLogger(StaffFilmServiceImpl.class);

    public StaffFilmServiceImpl(ModelMapper modelMapper, StaffFilmRepository staffFilmRepository, FilmRepository filmRepository, StaffRepository staffRepository) {
        this.modelMapper = modelMapper;
        this.staffFilmRepository = staffFilmRepository;
        this.filmRepository = filmRepository;
        this.staffRepository = staffRepository;
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public StaffFilmDto addStaffFilm(StaffFilmDto staffFilmDto) {
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(staffFilmDto.getFilmName())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        StaffEntity staffEntity = staffRepository.findById(UUID.fromString(staffFilmDto.getStaffName())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));

        StaffFilmEntity newStaffFilm = new StaffFilmEntity(staffFilmDto.getRole(), staffFilmDto.getAppearAs(), filmEntity, staffEntity);
        StaffFilmEntity savedStaffFilm = staffFilmRepository.save(newStaffFilm);
        return modelMapper.map(savedStaffFilm, StaffFilmDto.class);
    }

    @Override
    public List<StaffFilmDto> getAllStaffFromFilm(UUID id) {
        List<StaffFilmEntity> staffFilmEntities = staffFilmRepository.findAllStaffByFilmId(id.toString());
        if(staffFilmEntities == null){
            throw new ResourceNotFoundException("Resource not found");
        }
        return staffFilmEntities.stream().map(staffFilmEntity -> {
            return modelMapper.map(staffFilmEntity, StaffFilmDto.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public StaffFilmDto updateStaffFilm(UUID id, StaffFilmDto staffFilmDto) {
        StaffFilmEntity staffFilmEntity = staffFilmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        StaffFilmEntity newData = modelMapper.map(staffFilmDto, StaffFilmEntity.class);
        BeanUtils.copyProperties(newData, staffFilmEntity, Utils.getNullPropertyNames(newData));

        if(staffFilmDto.getFilmName() != null){
            FilmEntity filmEntity = filmRepository.findById(UUID.fromString(staffFilmDto.getFilmName())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
            staffFilmEntity.setFilm(filmEntity);
        }
        if(staffFilmDto.getStaffName() != null){
            StaffEntity staffEntity = staffRepository.findById(UUID.fromString(staffFilmDto.getStaffName())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
            staffFilmEntity.setStaff(staffEntity);
        }
        StaffFilmEntity savedStaffFilmEntity = staffFilmRepository.save(staffFilmEntity);
        return modelMapper.map(savedStaffFilmEntity, StaffFilmDto.class);
    }

    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public void deleteStaffFilm(UUID id) {
        staffFilmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        staffFilmRepository.deleteById(id);
    }
}
