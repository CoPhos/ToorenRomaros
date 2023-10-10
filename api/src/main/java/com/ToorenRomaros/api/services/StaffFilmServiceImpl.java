package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.staff.StaffFilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.staff.StaffFilmRepository;
import com.ToorenRomaros.api.repositories.staff.StaffRepository;
import com.nimbusds.jose.crypto.impl.ECDH;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class StaffFilmServiceImpl implements StaffFilmService{
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

    @Override
    public StaffFilmDto addStaffFilm(StaffFilmDto staffFilmDto) {
        try{
            FilmEntity filmEntity = filmRepository.findById(UUID.fromString(staffFilmDto.getFilmName())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
            StaffEntity staffEntity = staffRepository.findById(UUID.fromString(staffFilmDto.getStaffName())).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));

            StaffFilmEntity newStaffFilm = new StaffFilmEntity(staffFilmDto.getRole(), staffFilmDto.getAppearAs(), filmEntity, staffEntity);
            StaffFilmEntity savedStaffFilm = staffFilmRepository.save(newStaffFilm);
            return modelMapper.map(savedStaffFilm, StaffFilmDto.class);
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }
    @Override
    public List<StaffFilmDto> getAllStaffFromFilm(UUID id) {
        return null;
    }
    @Override
    public StaffFilmDto updateStaffFilm(UUID id, StaffFilmDto staffFilmDto) {
        return null;
    }
    @Override
    public void deleteStaffFilm(UUID id) {

    }
}
