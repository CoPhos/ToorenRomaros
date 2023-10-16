package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.staff.StaffFilmDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface StaffFilmService {
    StaffFilmDto addStaffFilm(StaffFilmDto staffFilmDto);

    List<StaffFilmDto> getAllStaffFromFilm(UUID id);

    StaffFilmDto updateStaffFilm(UUID id, StaffFilmDto staffFilmDto);

    void deleteStaffFilm(UUID id);
}
