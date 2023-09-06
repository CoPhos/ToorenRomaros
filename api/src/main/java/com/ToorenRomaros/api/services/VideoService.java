package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.media.VideoEntity;
import com.ToorenRomaros.api.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public void saveVideo(VideoEntity videoEntity){
        videoRepository.save(videoEntity);
    }

    public void deleteVideo(UUID id){
        videoRepository.deleteById(id);
    }
}
