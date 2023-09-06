package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.publication.PublicationEntity;
import com.ToorenRomaros.api.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    public void savePublication(PublicationEntity publicationEntity){
        publicationRepository.save(publicationEntity);
    }

    public void deletePublication(UUID id){
        publicationRepository.deleteById(id);
    }
}
