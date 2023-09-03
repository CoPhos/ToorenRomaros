package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.publication.Publication;
import com.ToorenRomaros.api.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    public void savePublication(Publication publication){
        publicationRepository.save(publication);
    }

    public void deletePublication(UUID id){
        publicationRepository.deleteById(id);
    }
}
