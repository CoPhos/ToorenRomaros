package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.genre.GenreFilmDto;
import com.ToorenRomaros.api.dto.staff.StaffFilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.genre.GenreEntity;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;
import com.ToorenRomaros.api.entities.staff.StaffFilmEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.genre.GenreFilmRepository;
import com.ToorenRomaros.api.repositories.genre.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GenreFilmServiceImpl implements GenreFilmService{

    private final GenreFilmRepository genreFilmRepository;
    private final FilmRepository filmRepository;
    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public GenreFilmServiceImpl(GenreFilmRepository genreFilmRepository, FilmRepository filmRepository, GenreRepository genreRepository, ModelMapper modelMapper) {
        this.genreFilmRepository = genreFilmRepository;
        this.filmRepository = filmRepository;
        this.genreRepository = genreRepository;
        this.modelMapper = modelMapper;
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public GenreFilmDto createGenreFilm(GenreFilmDto genreFilmDto) {
        GenreEntity genreEntity = genreRepository.findById(UUID.fromString(genreFilmDto.getGenre())).orElseThrow(() -> new ResourceNotFoundException("'" + genreFilmDto.getGenre() + "'"));
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(genreFilmDto.getFilm())).orElseThrow(() -> new ResourceNotFoundException("'" + genreFilmDto.getFilm() + "'"));

        GenreFilmEntity genreFilmEntity = new GenreFilmEntity(filmEntity, genreEntity);
        GenreFilmEntity savedGenreFilm = genreFilmRepository.save(genreFilmEntity);

        return modelMapper.map(savedGenreFilm, GenreFilmDto.class);
    }

    @Override
    public List<GenreFilmDto> getGenreFilm(UUID id) {
        List<GenreFilmEntity> genreFilmEntities = genreFilmRepository.findGenreByFilmId(id.toString());
        if(genreFilmEntities == null){
            throw new ResourceNotFoundException("Resource not found");
        }
        return genreFilmEntities.stream().map(genreFilmEntity -> {
            return modelMapper.map(genreFilmEntity, GenreFilmDto.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public GenreFilmDto updateGenreFilm(UUID id, GenreFilmDto genreFilmDto) {
        GenreFilmEntity genreFilmEntity = genreFilmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));

        if(genreFilmDto.getFilm() != null){
            FilmEntity filmEntity = filmRepository.findById(UUID.fromString(genreFilmDto.getFilm())).orElseThrow(() -> new ResourceNotFoundException("'" + genreFilmDto.getFilm() + "'"));
            genreFilmEntity.setFilm(filmEntity);
        }
        if(genreFilmDto.getGenre() != null){
            GenreEntity genreEntity = genreRepository.findById(UUID.fromString(genreFilmDto.getGenre())).orElseThrow(() -> new ResourceNotFoundException("'" + genreFilmDto.getGenre() + "'"));
            genreFilmEntity.setGenre(genreEntity);
        }
        GenreFilmEntity updatedGenreFilm = genreFilmRepository.save(genreFilmEntity);
        return modelMapper.map(updatedGenreFilm, GenreFilmDto.class);
    }
    @PreAuthorize("hasRole('adminrole') || hasRole('moderator')")
    @Override
    public void deleteGenreFilm(UUID id) {
        genreFilmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        genreFilmRepository.deleteById(id);
    }
}
