package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.media.Video;
import com.ToorenRomaros.api.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public void saveVideo(Video video){
        videoRepository.save(video);
    }

    public void deleteVideo(UUID id){
        videoRepository.deleteById(id);
    }
}
