package com.ToorenRomaros.api.services;

import com.ToorenRomaros.api.entities.media.ImageSizeEnum;
import com.ToorenRomaros.api.entities.media.ImageTypeEnum;
import com.ToorenRomaros.api.entities.staff.StaffEntity;
import com.ToorenRomaros.api.exeptions.UserNotFoundException;
import com.ToorenRomaros.api.repositories.media.ImageRepostiroy;
import com.ToorenRomaros.api.repositories.staff.StaffRepository;
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

@Service("ImageServiceStaffImpl")
public class ImageServiceStaffImpl  extends ImageServiceDefaultImpl{
    @Value("${images.folderPath}")
    private String FOLDER_PATH;
    private final StaffRepository staffRepository;
    private final ImageRepostiroy imageRepostiroy;
    public ImageServiceStaffImpl(ImageRepostiroy imageRepostiroy, ModelMapper modelMapper, StaffRepository staffRepository, ImageRepostiroy imageRepostiroy1) {
        super(imageRepostiroy, modelMapper);
        this.staffRepository = staffRepository;
        this.imageRepostiroy = imageRepostiroy1;
    }

    @Override
    public Map<String, String> uploadImage(MultipartFile originalImage, String ownerId, String imageType) throws IOException {
        byte[] bytes = originalImage.getBytes();
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));

        StaffEntity staffEntity = staffRepository.findById(UUID.fromString(ownerId)).orElseThrow(() -> new UserNotFoundException("Staff not found."));

        Map<String, String> data = new HashMap<>();
        data.put("original", processImage("staffs/"+ownerId+"/original_", bufferedImage, 0, 0, staffEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType), ImageSizeEnum.ONE_DPI,this.imageRepostiroy));
        data.put("240x280", processImage( "staffs/"+ownerId+"/240x280_", bufferedImage, 240, 280, staffEntity, FOLDER_PATH, ImageTypeEnum.valueOf(imageType),  ImageSizeEnum.TWO_DPI,this.imageRepostiroy));
        return data;
    }
}
