package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.media.ImageSizeEnum;
import com.ToorenRomaros.api.entities.media.ImageTypeEnum;
import com.ToorenRomaros.api.entities.publication.PostEntity;
import com.ToorenRomaros.api.entities.user.UserEntity;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.repositories.publication.PostRepository;
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

@Service("ImageServicePostImpl")
public class ImageServicePostImpl extends ImageServiceDefaultImpl{
    @Value("${images.folderPath}")
    private String FOLDER_PATH;
    private final PostRepository postRepository;
    private final ImageRepostiroy imageRepostiroy;

    public ImageServicePostImpl(ImageRepostiroy imageRepostiroy, ModelMapper modelMapper, PostRepository postRepository, ImageRepostiroy imageRepostiroy1) {
        super(imageRepostiroy, modelMapper);
        this.postRepository = postRepository;
        this.imageRepostiroy = imageRepostiroy1;
    }

    @Override
    public Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String imageType) throws IOException {
        byte[] bytes = originalImage.getBytes();
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));

        PostEntity postEntity = postRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new UserNotFoundException("'" + ownerId + "'"));

        Map<String, String> data = new HashMap<>();
        data.put("original", processImage("posts/"+ownerId+"/original_", bufferedImage, 0, 0, postEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType), ImageSizeEnum.THREE_DPI, this.imageRepostiroy));
        data.put("900x580", processImage( "posts/"+ownerId+"/900x580_", bufferedImage, 900, 580, postEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType), ImageSizeEnum.TWO_DPI, this.imageRepostiroy));
        data.put("450x240", processImage( "posts/"+ownerId+"/450x240_", bufferedImage, 450, 240, postEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType),  ImageSizeEnum.ONE_DPI,this.imageRepostiroy));
        return data;
    }
}
