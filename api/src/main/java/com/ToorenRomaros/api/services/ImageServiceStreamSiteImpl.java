package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.media.ImageSizeEnum;
import com.ToorenRomaros.api.entities.media.ImageTypeEnum;
import com.ToorenRomaros.api.entities.streamSite.StreamSiteEntity;
import com.ToorenRomaros.api.exeptions.ResourceNotFoundException;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.repositories.streamSite.StreamSiteRepository;
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

@Service("ImageServiceStreamSiteImpl")
public class ImageServiceStreamSiteImpl extends ImageServiceDefaultImpl{
    @Value("${images.folderPath}")
    private String FOLDER_PATH;
    private final StreamSiteRepository streamSiteRepository;
    private final ImageRepostiroy imageRepostiroy;

    public ImageServiceStreamSiteImpl(ImageRepostiroy imageRepostiroy, ModelMapper modelMapper, StreamSiteRepository streamSiteRepository, ImageRepostiroy imageRepostiroy1) {
        super(imageRepostiroy, modelMapper);
        this.streamSiteRepository = streamSiteRepository;
        this.imageRepostiroy = imageRepostiroy1;
    }

    @Override
    public Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String imageType) throws IOException {
        byte[] bytes = originalImage.getBytes();
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));

        StreamSiteEntity streamSiteEntity = streamSiteRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new ResourceNotFoundException("Stream site not found."));

        Map<String, String> data = new HashMap<>();
        data.put("original", processImage("streamsites/"+ownerId+"/original_", bufferedImage, 0, 0, streamSiteEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType), ImageSizeEnum.ONE_DPI,this.imageRepostiroy));
        data.put("150x150", processImage( "streamsites/"+ownerId+"/150x150_", bufferedImage, 150, 150, streamSiteEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType),  ImageSizeEnum.TWO_DPI,this.imageRepostiroy));
        return data;
    }
}
