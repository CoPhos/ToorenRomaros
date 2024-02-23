package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.staff.CreateStaffFilmDto;
import com.ToorenRomaros.api.dto.staff.GetStaffFilmDto;

import java.util.List;
import java.util.UUID;

public interface StaffFilmService {
    GetStaffFilmDto addStaffFilm(CreateStaffFilmDto createStaffFilmDto);
    List<GetStaffFilmDto> getAllStaffFromFilm(UUID id);
    void deleteStaffFilm(UUID id);
}
