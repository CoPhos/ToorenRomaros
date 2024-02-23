package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.film.FilmEntity;
import com.ToorenRomaros.api.entities.media.ImageSizeEnum;
import com.ToorenRomaros.api.entities.media.ImageTypeEnum;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("ImageServiceFilmImpl")
public class ImageServiceFilmImpl extends ImageServiceDefaultImpl{
    @Value("${images.folderPath}")
    private String FOLDER_PATH;
    private final FilmRepository filmRepository;
    private final ImageRepostiroy imageRepostiroy;

    public ImageServiceFilmImpl(FilmRepository filmRepository, ImageRepostiroy imageRepostiroy, ModelMapper modelMapper) {
        super(imageRepostiroy, modelMapper);
        this.filmRepository = filmRepository;
        this.imageRepostiroy = imageRepostiroy;
    }

    @Override
    public Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String imageType) throws IOException {
        byte[] bytes = originalImage.getBytes();
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));

        FilmEntity filmEntity = filmRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("Film not found."));

        Map<String, String> data = new HashMap<>();
        data.put("original", processImage("films/"+ownerId+"/original_", bufferedImage, 0, 0, filmEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType),ImageSizeEnum.THREE_DPI,  this.imageRepostiroy));
        data.put("170x280", processImage( "films/"+ownerId+"/170x280_", bufferedImage, 170, 280, filmEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType),  ImageSizeEnum.TWO_DPI,this.imageRepostiroy));
        return data;
    }
}
