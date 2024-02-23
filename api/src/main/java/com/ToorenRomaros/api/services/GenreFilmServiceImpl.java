package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.genre.CreateGenreFilmDto;
import com.ToorenRomaros.api.dto.genre.GetGenreFilmDto;
import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.genre.GenreEntity;
import com.ToorenRomaros.api.entities.genre.GenreFilmEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.genre.GenreFilmRepository;
import com.ToorenRomaros.api.repositories.genre.GenreRepository;
import org.modelmapper.ModelMapper;
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
    @Override
    public GetGenreFilmDto createGenreFilm(CreateGenreFilmDto createGenreFilmDto) {
        GenreEntity genreEntity = genreRepository.findById(UUID.fromString(createGenreFilmDto.getGenre())).orElseThrow(() -> new ResourceNotFoundException("Genre not found."));
        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(createGenreFilmDto.getFilm())).orElseThrow(() -> new ResourceNotFoundException("Film not found."));
        GenreFilmEntity genreFilmEntity = new GenreFilmEntity(filmEntity, genreEntity);
        GenreFilmEntity savedGenreFilm = genreFilmRepository.save(genreFilmEntity);
        return modelMapper.map(savedGenreFilm, GetGenreFilmDto.class);
    }
    @Override
    public List<GetGenreFilmDto> getGenreFilm(UUID id) {
        List<GenreFilmEntity> genreFilmEntities = genreFilmRepository.findAllByFilmId(id.toString());
        return genreFilmEntities.stream().map(genreFilmEntity -> {
            return modelMapper.map(genreFilmEntity, GetGenreFilmDto.class);
        }).collect(Collectors.toList());
    }
    @Override
    public GetGenreFilmDto updateGenreFilm(UUID id, CreateGenreFilmDto createGenreFilmDto) {
        GenreFilmEntity genreFilmEntity = genreFilmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film not found."));
        if(createGenreFilmDto.getFilm() != null){
            FilmEntity filmEntity = filmRepository.findById(UUID.fromString(createGenreFilmDto.getFilm())).orElseThrow(() -> new ResourceNotFoundException("'" + createGenreFilmDto.getFilm() + "'"));
            genreFilmEntity.setFilm(filmEntity);
        }
        if(createGenreFilmDto.getGenre() != null){
            GenreEntity genreEntity = genreRepository.findById(UUID.fromString(createGenreFilmDto.getGenre())).orElseThrow(() -> new ResourceNotFoundException("'" + createGenreFilmDto.getGenre() + "'"));
            genreFilmEntity.setGenre(genreEntity);
        }
        GenreFilmEntity updatedGenreFilm = genreFilmRepository.save(genreFilmEntity);
        return modelMapper.map(updatedGenreFilm, GetGenreFilmDto.class);
    }
    @Override
    public void deleteGenreFilm(UUID id) {
        genreFilmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("'" + id + "'"));
        genreFilmRepository.deleteById(id);
    }
}
