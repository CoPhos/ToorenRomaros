package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.dto.media.GetListImagesDto;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.entities.media.ImageSizeEnum;
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
    Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String imageType) throws IOException;
    byte[] getImageById(String imageId) throws IOException;
    List<GetListImagesDto> getImageByImageType(String imageType, String ownerId);
    List<GetListImagesDto> getAllImagesFromStaffByImageTypeAndFilmid(String imageType, String filmid);
    List<GetListImagesDto> getAllImagesFromStreamSiteByImageTypeAndStreamSiteId(String imageType, String filmid);

    default String processImage(String suffix,
                                BufferedImage bufferedImage,
                                int width, int height,
                                Object entity,
                                String folderPath,
                                ImageTypeEnum imageType,
                                ImageSizeEnum imageSize,
                                ImageRepostiroy imageRepostiroy) throws IOException {
        String filePath = folderPath + suffix + UUID.randomUUID() + ".jpg";

        File directory = new File(filePath).getParentFile();
        if (!directory.exists()) {
            if(directory.mkdirs()){
                // Directories created successfully
            }
        }

        if (width > 0 && height > 0) {
            BufferedImage resizedImage = Scalr.resize(bufferedImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, width, height, Scalr.OP_ANTIALIAS);
            ImageIO.write(resizedImage, "jpg", new File(filePath));
        } else {
            ImageIO.write(bufferedImage, "jpg", new File(filePath));
        }
        ImageEntity imageEntity = new ImageEntity(filePath, LocalDateTime.now(), imageType, imageSize, entity);
        ImageEntity savedImage = imageRepostiroy.save(imageEntity);
        return savedImage.getId().toString();
    }
}

