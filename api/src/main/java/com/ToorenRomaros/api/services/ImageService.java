package com.ToorenRomaros.api.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ImageService {
    String uploadImage(MultipartFile file, String imageSize, String ownerId, String ownerType, String imageType) throws IOException;
    byte[] getImageById(String imageId) throws IOException;
    byte[] getImageByOwnerIdTypeSizeOwnerType(String ownerId, String type, String size, String ownerType) throws IOException;
    List<UUID> getAllImagesByOwnerIdTypeSizeOwnerType(String ownerId, String type, String size, String ownerType);
}
