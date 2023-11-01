package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.repositories.media.RichTextRepository;
import com.ToorenRomaros.api.repositories.media.VideoRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepostiroy imageRepostiroy;
    private final UserRepository userRepository;
    private final RichTextRepository richTextRepository;
    private final FilmRepository filmRepository;
    private final VideoRepository videoRepository;
    private final ModelMapper modelMapper;
    @Value("${images.folderPath}")
    private String FOLDER_PATH;
    private static final Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    public ImageServiceImpl(ImageRepostiroy imageRepostiroy, UserRepository userRepository, RichTextRepository richTextRepository, FilmRepository filmRepository, VideoRepository videoRepository, ModelMapper modelMapper) {
        this.imageRepostiroy = imageRepostiroy;
        this.userRepository = userRepository;
        this.richTextRepository = richTextRepository;
        this.filmRepository = filmRepository;
        this.videoRepository = videoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String uploadImageToFileSystem(MultipartFile file, String imageSize, String ownerId, String ownerType, String imageType) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        Object ownerEntity;

        switch (ownerType) {
            case "F":
                ownerEntity = filmRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("'" + ownerId + "'"));
                break;
            case "U":
                ownerEntity = userRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("'" + ownerId + "'"));
                break;
            case "RT":
                ownerEntity = richTextRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("'" + ownerId + "'"));
                break;
            case "V":
                ownerEntity = videoRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("'" + ownerId + "'"));
                break;
            default:
                throw new IllegalArgumentException("Unknown owner type: " + ownerType);
        }

        ImageEntity imageEntity = new ImageEntity(filePath, imageSize, LocalDateTime.now(), imageType, ownerEntity);
        imageRepostiroy.save(imageEntity);

        file.transferTo(new File(filePath));
        return "file uploaded successfully : " + filePath;
    }

    @Override
    public byte[] getProfileImageFromFileSystem(String userId, String imageSize) throws IOException {
        ImageEntity fileData = imageRepostiroy.findProfilePhotoByUserId(userId, imageSize).orElseThrow(() -> new ResourceNotFoundException("'" + userId + "'"));
        String filePath=fileData.getFilePath();
        return Files.readAllBytes(new File(filePath).toPath());
    }
}
