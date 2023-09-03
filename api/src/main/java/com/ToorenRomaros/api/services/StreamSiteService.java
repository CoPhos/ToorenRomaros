package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.StreamSite;
import com.ToorenRomaros.api.repositories.StreamSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StreamSiteService {

    @Autowired
    private StreamSiteRepository streamSiteRepository;

    public void saveStreamSite(StreamSite streamSite){
        streamSiteRepository.save(streamSite);
    }

    public void deleteStreamSite(UUID id){
        streamSiteRepository.deleteById(id);
    }
}
