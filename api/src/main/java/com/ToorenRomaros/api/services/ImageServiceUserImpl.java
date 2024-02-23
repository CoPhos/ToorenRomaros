package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.media.ImageSizeEnum;
import com.ToorenRomaros.api.entities.media.ImageTypeEnum;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.repositories.user.UserRepository;
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

@Service("ImageServiceUserImpl")
public class ImageServiceUserImpl extends ImageServiceDefaultImpl{
    @Value("${images.folderPath}")
    private String FOLDER_PATH;
    private final UserRepository userRepository;
    private final ImageRepostiroy imageRepostiroy;
    public ImageServiceUserImpl(ImageRepostiroy imageRepostiroy, ModelMapper modelMapper, UserRepository userRepository, ImageRepostiroy imageRepostiroy1) {
        super(imageRepostiroy, modelMapper);
        this.userRepository = userRepository;
        this.imageRepostiroy = imageRepostiroy1;
    }

    @Override
    public Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String imageType) throws IOException {
        byte[] bytes = originalImage.getBytes();
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));

        UserEntity userEntity = userRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new UserNotFoundException("User not found."));

        Map<String, String> data = new HashMap<>();
        data.put("80x80", processImage("users/"+ownerId+"/80x80_", bufferedImage, 80, 80, userEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType), ImageSizeEnum.ONE_DPI,this.imageRepostiroy));
        data.put("170x280", processImage( "users/"+ownerId+"/170x280_", bufferedImage, 170, 280, userEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType),  ImageSizeEnum.TWO_DPI,this.imageRepostiroy));
        return data;
    }
}
