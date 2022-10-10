package byfayzullayev.startup.controller;

import byfayzullayev.startup.entity.file.ImageData;
import byfayzullayev.startup.model.response.ImageUploadResponse;
import byfayzullayev.startup.service.image.ImageDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/onlineExam/image")
public class ImageDataController {

    private final ImageDataService imageDataService;

    public ImageDataController(ImageDataService imageDataService) {
        this.imageDataService = imageDataService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        ImageUploadResponse response = imageDataService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/info/{name}")
    public ResponseEntity<?> getImageInfoByName(@PathVariable("name") String name) {
        ImageData image = imageDataService.getInfoByImageByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImageByName(@PathVariable("id") long id) {
        byte[] image = imageDataService.getImage(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }


}
