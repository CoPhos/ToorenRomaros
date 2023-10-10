package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.staff.StaffFilmDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface StaffFilmService {

    public StaffFilmDto addStaffFilm(StaffFilmDto staffFilmDto);
    public List<StaffFilmDto> getAllStaffFromFilm(UUID id);
    public StaffFilmDto updateStaffFilm(UUID id, StaffFilmDto staffFilmDto);
    public void deleteStaffFilm(UUID id);
}
