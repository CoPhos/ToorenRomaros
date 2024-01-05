package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.media.ImageEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.film.FilmRepository;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.repositories.media.VideoRepository;
import com.ToorenRomaros.api.repositories.publication.PostRepository;
import com.ToorenRomaros.api.repositories.user.UserRepository;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl {
    private final ImageRepostiroy imageRepostiroy;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final FilmRepository filmRepository;
    private final VideoRepository videoRepository;

    @Value("${images.folderPath}")
    private String FOLDER_PATH;
    private static final Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    public ImageServiceImpl(ImageRepostiroy imageRepostiroy, UserRepository userRepository, PostRepository postRepository, FilmRepository filmRepository, VideoRepository videoRepository) {
        this.imageRepostiroy = imageRepostiroy;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.filmRepository = filmRepository;
        this.videoRepository = videoRepository;

    }

//    @Override
//    public Map<String, String> uploadImage(MultipartFile file, String ownerId, String ownerType, String imageType) throws IOException {
//        return null;
//    }

//    @Override
//    public byte[] getImageById(String imageId) throws IOException {
//        return new byte[0];
//    }
//    @Override
//    public Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String ownerType, String imageType) throws IOException {
//        List<ImageEntity> newImagesEntities = new ArrayList<>();
//        HashMap<String, BufferedImage> resizedImages = resizeImages(originalImage);
//        Object ownerEntity;
//
//        switch (ownerType) {
//            case "F":
//                ownerEntity = filmRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("'" + ownerId + "'"));
//                break;
//            case "U":
//                ownerEntity = userRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("'" + ownerId + "'"));
//                break;
//            case "RT":
//                ownerEntity = postRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("'" + ownerId + "'"));
//                break;
//            case "V":
//                ownerEntity = videoRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("'" + ownerId + "'"));
//                break;
//            default:
//                throw new IllegalArgumentException("Unknown owner type: " + ownerType);
//        }
//
//        for (Map.Entry<String, BufferedImage> entry : resizedImages.entrySet()) {
//            String filePath = FOLDER_PATH + entry.getValue().getWidth() + "x" + entry.getValue().getHeight() + "-" + originalImage.getOriginalFilename();
//            newImagesEntities.add(new ImageEntity(filePath, entry.getKey(), LocalDateTime.now(), imageType, ownerEntity));
//            ImageIO.write(entry.getValue(), "jpg", new File(filePath));
//        }
//
//        List<ImageEntity> savedImages = imageRepostiroy.saveAll(newImagesEntities);
//        Map<String, String> data = new HashMap<>();
//        for (ImageEntity imageEntity: savedImages){
//            data.put(imageEntity.getImageSize(), imageEntity.getId().toString());
//        }
//        return data;
//    }
//
//    @Override
//    public byte[] getImageById(String imageId) throws IOException {
//        ImageEntity fileData = imageRepostiroy.findById(UUID.fromString(imageId)).orElseThrow(() -> new ResourceNotFoundException("'" + imageId + "'"));
//        String filePath = fileData.getFilePath();
//        return Files.readAllBytes(new File(filePath).toPath());
//    }

//    @Override
//    public byte[] getImageByOwnerIdTypeSizeOwnerType(String ownerId, String type, String size, String ownerType) throws IOException {
//        ImageEntity fileData = imageRepostiroy.findLatestImageFromImageByOwnerIdTypeSizeOwnerType(ownerId, type, size, ownerType).orElseThrow(() -> new ResourceNotFoundException("File doesn't exists"));
//        String filePath = fileData.getFilePath();
//        return Files.readAllBytes(new File(filePath).toPath());
//    }
//
//    @Override
//    public List<UUID> getAllImagesByOwnerIdTypeSizeOwnerType(String ownerId, String type, String size, String ownerType) {
//        List<ImageEntity> imageEntities = imageRepostiroy.findAllImagesFromImageByOwnerIdTypeSizeOwnerType(ownerId, type, size, ownerType);
//        if (imageEntities.isEmpty()) {
//            throw new ResourceNotFoundException("Not files found");
//        }
//        return imageEntities.stream().map(ImageEntity::getId).collect(Collectors.toList());
//    }

    public HashMap<String, BufferedImage> resizeImages(MultipartFile originalImage) throws IOException {
        HashMap<String, BufferedImage> resizedImages = new HashMap<>();

        byte[] bytes = originalImage.getBytes();
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
        resizedImages.put("Desktop", bufferedImage);

        BufferedImage resizedImage1 = Scalr.resize(bufferedImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, 1024, 768, Scalr.OP_ANTIALIAS);
        resizedImages.put("Tablet", resizedImage1);

        BufferedImage resizedImage2 = Scalr.resize(bufferedImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, 667, 375, Scalr.OP_ANTIALIAS);
        resizedImages.put("Mobile", resizedImage2);

        return resizedImages;
    }

}
