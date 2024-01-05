package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.entities.media.ImageTypeEnum;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("ImageServiceFilmImpl")
public class ImageServiceFilmImpl extends ImageServiceDefaultImpl{
    @Value("${images.folderPath}")
    private String FOLDER_PATH;
    private final FilmRepository filmRepository;
    private final ImageRepostiroy imageRepostiroy;

    public ImageServiceFilmImpl(FilmRepository filmRepository, ImageRepostiroy imageRepostiroy) {
        super(imageRepostiroy);
        this.filmRepository = filmRepository;
        this.imageRepostiroy = imageRepostiroy;
    }

    @Override
    public Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String ownerType, String imageType) throws IOException {
        byte[] bytes = originalImage.getBytes();
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));

        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("'" + ownerId + "'"));

        Map<String, String> data = new HashMap<>();
        data.put("original", processImage(originalImage, "_original", bufferedImage, 0, 0, filmEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType), this.imageRepostiroy));
        data.put("resized", processImage(originalImage, "_170x280", bufferedImage, 170, 280, filmEntity, FOLDER_PATH,ImageTypeEnum.valueOf(imageType), this.imageRepostiroy));
        return data;
    }
}
