package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.staff.CreateStaffFilmDto;
import com.ToorenRomaros.api.dto.staff.GetStaffFilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.staff.StaffFilmRepository;
import com.ToorenRomaros.api.repositories.staff.StaffRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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
    public StaffFilmServiceImpl(ModelMapper modelMapper, StaffFilmRepository staffFilmRepository, FilmRepository filmRepository, StaffRepository staffRepository) {
        this.modelMapper = modelMapper;
        this.staffFilmRepository = staffFilmRepository;
        this.filmRepository = filmRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public GetStaffFilmDto addStaffFilm(CreateStaffFilmDto createStaffFilmDto) {
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(createStaffFilmDto.getFilmName())).orElseThrow(() -> new ResourceNotFoundException("Film not found"));
        StaffEntity staffEntity = staffRepository.findById(UUID.fromString(createStaffFilmDto.getStaffId())).orElseThrow(() -> new ResourceNotFoundException("Staff not found"));

        StaffFilmEntity newStaffFilm = new StaffFilmEntity(createStaffFilmDto.getRole(), createStaffFilmDto.getAppearAs(), filmEntity, staffEntity);
        StaffFilmEntity savedStaffFilm = staffFilmRepository.save(newStaffFilm);
        return modelMapper.map(savedStaffFilm, GetStaffFilmDto.class);
    }
    @Override
    public List<GetStaffFilmDto> getAllStaffFromFilm(UUID id) {
        List<StaffFilmEntity> staffFilmEntities = staffFilmRepository.findAllStaffByFilmId(id.toString());
        if(staffFilmEntities == null){
            throw new ResourceNotFoundException("Staff not found");
        }
        return staffFilmEntities.stream().map(staffFilmEntity -> {
            return modelMapper.map(staffFilmEntity, GetStaffFilmDto.class);
        }).collect(Collectors.toList());
    }
    @Override
    public void deleteStaffFilm(UUID id) {
        staffFilmRepository.findById(id)
                .ifPresentOrElse(staffFilmRepository::delete, () -> {
                    throw new ResourceNotFoundException("Resource not found");
                });
    }
}
