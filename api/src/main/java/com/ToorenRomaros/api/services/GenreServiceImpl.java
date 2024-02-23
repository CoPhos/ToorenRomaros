package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.genre.GenreDto;
import com.ToorenRomaros.api.entities.genre.GenreEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.genre.GenreRepository;
import com.ToorenRomaros.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenreServiceImpl implements GenreService{

    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public GenreServiceImpl(GenreRepository genreRepository, ModelMapper modelMapper) {
        this.genreRepository = genreRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        GenreEntity newGenreEntity = modelMapper.map(genreDto, GenreEntity.class);
        GenreEntity savedGenreEntity = genreRepository.save(newGenreEntity);
        return modelMapper.map(savedGenreEntity, GenreDto.class);
    }
    @Override
    public GenreDto getGenre(UUID id) {
        GenreEntity genreEntity = genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre not found."));
        return modelMapper.map(genreEntity, GenreDto.class);
    }
    @Override
    public GenreDto updateGenre(UUID id, GenreDto genreDto) {
        GenreEntity genreEntity = modelMapper.map(genreDto, GenreEntity.class);
        GenreEntity newGenreEntity = genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre not found."));
        BeanUtils.copyProperties(genreEntity, newGenreEntity, Utils.getNullPropertyNames(genreEntity));
        GenreEntity savedGenreEntity = genreRepository.save(newGenreEntity);
        return modelMapper.map(savedGenreEntity, GenreDto.class);
    }
    @Override
    public void deleteGenre(UUID id) {
        genreRepository.findById(id)
                .ifPresentOrElse(genreRepository::delete, () -> {
                    throw new ResourceNotFoundException("Genre not found.");
                });
    }
}
