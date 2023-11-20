package com.ToorenRomaros.api.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ImageService {
    Map<String, String> uploadImage(MultipartFile file, String ownerId, String ownerType, String imageType) throws IOException;
    byte[] getImageById(String imageId) throws IOException;
    byte[] getImageByOwnerIdTypeSizeOwnerType(String ownerId, String type, String size, String ownerType) throws IOException;
    List<UUID> getAllImagesByOwnerIdTypeSizeOwnerType(String ownerId, String type, String size, String ownerType);
}
