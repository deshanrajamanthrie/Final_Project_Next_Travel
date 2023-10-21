package lk.ijse.gdse.vehicle.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    public void saveImages(MultipartFile file) throws IOException;
}
