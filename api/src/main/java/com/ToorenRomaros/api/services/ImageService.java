package com.ToorenRomaros.api.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String uploadImageToFileSystem(MultipartFile file, String imageSize, String ownerId, String ownerType, String imageType) throws IOException;
    byte[] getProfileImageFromFileSystem(String userId, String imageSize) throws IOException;
}
