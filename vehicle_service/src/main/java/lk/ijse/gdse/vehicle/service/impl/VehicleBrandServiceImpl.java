package lk.ijse.gdse.vehicle.service.impl;

import lk.ijse.gdse.vehicle.dto.VehicleBrandDTO;
import lk.ijse.gdse.vehicle.dto.VehicleCategoryDTO;
import lk.ijse.gdse.vehicle.entity.VehicleBrand;
import lk.ijse.gdse.vehicle.entity.VehicleCategory;
import lk.ijse.gdse.vehicle.repo.VehicleBrandRepo;
import lk.ijse.gdse.vehicle.service.VehicleBrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleBrandServiceImpl implements VehicleBrandService {

    @Autowired
    VehicleBrandRepo vehicleBrandRepo;

    @Autowired
    ModelMapper mapper;


    public VehicleBrandDTO saveVehicleBrand(VehicleBrandDTO dto) {
        if (vehicleBrandRepo.existsById(dto.getVehicleId())) {
            throw new RuntimeException("Vehicle Already Exists!");
        } else {
            vehicleBrandRepo.save(mapper.map(dto, VehicleBrand.class));
        }
        return dto;
    }


    public VehicleCategoryDTO updateVehicleCategory(VehicleCategoryDTO dto){
        if (!vehicleBrandRepo.existsById(dto.getCategoryId())){
            throw  new RuntimeException("Vehicle CateGory Not Found!");
        }else {
            vehicleBrandRepo.save(mapper.map(dto,VehicleBrand.class));
        }
        return  dto;
    }


}