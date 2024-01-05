package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.entities.media.ImageTypeEnum;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import org.imgscalr.Scalr;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ImageService {
    Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String ownerType, String imageType) throws IOException;
    byte[] getImageById(String imageId) throws IOException;

    default String processImage(MultipartFile originalImage,
                                String suffix,
                                BufferedImage bufferedImage,
                                int width, int height,
                                Object entity,
                                String folderPath,
                                ImageTypeEnum imageType,
                                ImageRepostiroy imageRepostiroy) throws IOException {
        String filePath = folderPath + originalImage.getOriginalFilename() + suffix;
        ImageEntity imageEntity = new ImageEntity(filePath, LocalDateTime.now(), imageType, entity);
        ImageEntity savedImage = imageRepostiroy.save(imageEntity);

        if (width > 0 && height > 0) {
            BufferedImage resizedImage = Scalr.resize(bufferedImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, width, height, Scalr.OP_ANTIALIAS);
            ImageIO.write(resizedImage, "jpg", new File(filePath));
        } else {
            ImageIO.write(bufferedImage, "jpg", new File(filePath));
        }
        return savedImage.getId().toString();
    }
}
