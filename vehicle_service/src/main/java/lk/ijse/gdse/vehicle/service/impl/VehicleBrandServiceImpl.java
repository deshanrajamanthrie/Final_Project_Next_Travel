package lk.ijse.gdse.vehicle.service.impl;

import lk.ijse.gdse.vehicle.dto.VehicleBrandDTO;
import lk.ijse.gdse.vehicle.dto.VehicleCategoryDTO;
import lk.ijse.gdse.vehicle.entity.VehicleBrand;
import lk.ijse.gdse.vehicle.entity.VehicleCategory;
import lk.ijse.gdse.vehicle.repo.VehicleBrandRepo;
import lk.ijse.gdse.vehicle.service.VehicleBrandService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleBrandServiceImpl implements VehicleBrandService {

    @Autowired
    VehicleBrandRepo vehicleBrandRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public VehicleBrandDTO saveVehicleBrand(VehicleBrandDTO dto) {
        if (vehicleBrandRepo.existsById(dto.getVehicleId())) {
            throw new RuntimeException("Vehicle Already Exists!");
        } else {
            vehicleBrandRepo.save(mapper.map(dto, VehicleBrand.class));
        }
        return dto;
    }

    @Override
    public VehicleBrandDTO updateVehicleBrand(VehicleBrandDTO dto) {
        if (!vehicleBrandRepo.existsById(dto.getVehicleId())) {
            throw new RuntimeException("Vehicle not Found!");
        } else {
            vehicleBrandRepo.save(mapper.map(dto, VehicleBrand.class));
        }
        return dto;
    }
    @Override
    public List<VehicleBrandDTO> getAllVehicle() {
        List<VehicleBrand> all = vehicleBrandRepo.findAll();

        return mapper.map(all, new TypeToken<List<VehicleBrandDTO>>() {
        }.getType());
    }
    @Override
    public VehicleBrandDTO searchVehicleBrand(Long id) {
        if (!vehicleBrandRepo.existsById(id)) {
            throw new RuntimeException("Vehicle not Found!");
        } else {
            VehicleBrand vehicleBrand = vehicleBrandRepo.findById(id).get();
            return mapper.map(vehicleBrand, VehicleBrandDTO.class);
        }
    }
    @Override
    public void deleteVehicleBrand(Long id){
       if(!vehicleBrandRepo.existsById(id)){
           throw new RuntimeException("Vehicle not Found!");
       }else{
           vehicleBrandRepo.delete(vehicleBrandRepo.findById(id).get());
       }
    }


}