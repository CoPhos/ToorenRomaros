package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.media.PhotoEntity;
import com.ToorenRomaros.api.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public void savePhoto(PhotoEntity photoEntity){
        photoRepository.save(photoEntity);
    }

    public void deletePhoto(UUID id){
        photoRepository.deleteById(id);
    }
}
