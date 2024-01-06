package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.controllers.ImageController;
import com.ToorenRomaros.api.dto.media.GetAllImagesByTypeAndOwnerIdDto;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

@Service("ImageServiceDefaultImpl")
public class ImageServiceDefaultImpl implements ImageService {
    private static final Logger log = LoggerFactory.getLogger(ImageServiceDefaultImpl.class);
    private final ImageRepostiroy imageRepostiroy;
    private final ModelMapper modelMapper;

    public ImageServiceDefaultImpl(ImageRepostiroy imageRepostiroy, ModelMapper modelMapper) {
        this.imageRepostiroy = imageRepostiroy;
        this.modelMapper = modelMapper;
    }

    @Override
    public Map<String, String> uploadImage(MultipartFile originalImage, String ownerType, String imageType) throws IOException {
        return null;
    }

    @Override
    public List<GetAllImagesByTypeAndOwnerIdDto> getImageByImageType(String imageType, String ownerId) {
        List<ImageEntity> imageEntities = imageRepostiroy.findAllImageByImageType(imageType, ownerId);
        if (imageEntities.isEmpty()) {
            throw new ResourceNotFoundException("No Images Were Found ");
        } else {
            return imageEntities.stream().map(imageEntity -> modelMapper.map(imageEntity, GetAllImagesByTypeAndOwnerIdDto.class)).collect(Collectors.toList());
        }
    }

    @Override
    public byte[] getImageById(String imageId) throws IOException {
        ImageEntity fileData = imageRepostiroy.findById(UUID.fromString(imageId)).orElseThrow(() -> new ResourceNotFoundException("'" + imageId + "'"));
        String filePath = fileData.getFilePath();
        return Files.readAllBytes(new File(filePath).toPath());
    }
}
