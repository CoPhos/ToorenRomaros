package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.UUID;

@Service
public class ImageServiceDefaultImpl implements ImageService{
    private final ImageRepostiroy imageRepostiroy;

    public ImageServiceDefaultImpl(ImageRepostiroy imageRepostiroy) {
        this.imageRepostiroy = imageRepostiroy;
    }

    @Override
    public Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String ownerType, String imageType) throws IOException {
        return null;
    }

    @Override
    public byte[] getImageById(String imageId) throws IOException {
        ImageEntity fileData = imageRepostiroy.findById(UUID.fromString(imageId)).orElseThrow(() -> new ResourceNotFoundException("'" + imageId + "'"));
        String filePath = fileData.getFilePath();
        return Files.readAllBytes(new File(filePath).toPath());
    }
}
