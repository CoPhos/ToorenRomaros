package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.genre.GenreEntity;
import com.ToorenRomaros.api.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public void saveGenre(GenreEntity genreEntity){
        genreRepository.save(genreEntity);
    }

    public void deleteGenre(UUID id){
        genreRepository.deleteById(id);
    }
}
