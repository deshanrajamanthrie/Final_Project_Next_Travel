package lk.ijse.gdse.vehicle.service.impl;

import lk.ijse.gdse.vehicle.entity.VehicleImage;
import lk.ijse.gdse.vehicle.repo.VehicleImageRepo;
import lk.ijse.gdse.vehicle.service.ImageService;
import lk.ijse.gdse.vehicle.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    VehicleImageRepo repo;

    public void saveImages(MultipartFile file) throws IOException {
      repo.save(VehicleImage.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .vehicleImage(ImageUtil.compressImage(file.getBytes())).build());

    }




}
