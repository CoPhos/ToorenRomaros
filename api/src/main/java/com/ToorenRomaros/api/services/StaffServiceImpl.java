package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.staff.CreateStaffDto;
import com.ToorenRomaros.api.dto.staff.GetStaffDto;
import com.ToorenRomaros.api.dto.staff.UpdateStaffDto;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.staff.StaffRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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
    @Override
    public GetStaffDto createStaff(CreateStaffDto staffAddRequestDto) {
        StaffEntity newStaff = modelMapper.map(staffAddRequestDto, StaffEntity.class);
        StaffEntity savedStaff =staffRepository.save(newStaff);
        return modelMapper.map(savedStaff, GetStaffDto.class);
    }
    @Override
    public GetStaffDto getStaffById(UUID id) {
        StaffEntity staffEntity = staffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Staff not found"));
        return modelMapper.map(staffEntity, GetStaffDto.class);
    }
    @Override
    public GetStaffDto updateStaff(UUID id, UpdateStaffDto staffAddRequestDto) {
        StaffEntity newStaff = staffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Staff not found"));
        StaffEntity newData = modelMapper.map(staffAddRequestDto, StaffEntity.class);

        BeanUtils.copyProperties(newData, newStaff, Utils.getNullPropertyNames(newData));

        StaffEntity savedStaff = staffRepository.save(newStaff);
        return modelMapper.map(savedStaff, GetStaffDto.class);
    }
    @Override
    public void deleteStaffByid(UUID id) {
        staffRepository.findById(id)
                .ifPresentOrElse(staffRepository::delete, () -> {
                    throw new ResourceNotFoundException("Staff not found");
                });
    }
}
