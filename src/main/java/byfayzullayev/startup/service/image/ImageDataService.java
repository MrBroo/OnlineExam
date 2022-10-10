package byfayzullayev.startup.service.image;


import byfayzullayev.startup.Repository.ImageDataRepository;
import byfayzullayev.startup.entity.file.ImageData;
import byfayzullayev.startup.model.response.ImageUploadResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataService {

    private final ImageDataRepository imageDataRepository;

    public ImageDataService(ImageDataRepository imageDataRepository) {
        this.imageDataRepository = imageDataRepository;
    }

    public ImageUploadResponse uploadImage(MultipartFile file) throws IOException {

        imageDataRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());

        return new ImageUploadResponse("Image uploaded successfully: " +
                file.getOriginalFilename());

    }

    @Transactional
    public ImageData getInfoByImageByName(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);

        return ImageData.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();

    }

    @Transactional
    public byte[] getImage(long id) {
        Optional<ImageData> dbImage = imageDataRepository.findById(id);
        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
        return image;
    }


}