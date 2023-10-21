package lk.ijse.gdse.vehicle.controller;

import lk.ijse.gdse.vehicle.service.ImageService;
import org.modelmapper.internal.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/image")
@CrossOrigin
public class ImageController {


    @Autowired
    ImageService service;

    @PostMapping(consumes = MediaType.ALL_VALUE)
    public void postImage(@RequestParam("image")MultipartFile file) throws IOException {
        service.saveImages(file);
    }


}
