package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.staff.StaffDto;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.staff.StaffRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StaffServiceImpl implements StaffService{

    private final StaffRepository staffRepository;
    private final ModelMapper modelMapper;
    public StaffServiceImpl(StaffRepository staffRepository, ModelMapper modelMapper) {
        this.staffRepository = staffRepository;
        this.modelMapper = modelMapper;
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public StaffDto createStaff(StaffDto staffAddRequestDto) {
        StaffEntity newStaff = modelMapper.map(staffAddRequestDto, StaffEntity.class);
        StaffEntity savedStaff =staffRepository.save(newStaff);
        return modelMapper.map(savedStaff, StaffDto.class);
    }
    @Override
    public StaffDto getStaffById(UUID id) {
        StaffEntity staffEntity = staffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        return modelMapper.map(staffEntity, StaffDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public StaffDto updateStaff(UUID id, StaffDto staffAddRequestDto) {
        StaffEntity newStaff = staffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        StaffEntity newData = modelMapper.map(staffAddRequestDto, StaffEntity.class);

        BeanUtils.copyProperties(newData, newStaff, Utils.getNullPropertyNames(newData));

        StaffEntity savedStaff = staffRepository.save(newStaff);
        return modelMapper.map(savedStaff, StaffDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public void deleteStaffByid(UUID id) {
        StaffEntity staffEntity = staffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        staffRepository.delete(staffEntity);
    }
}
