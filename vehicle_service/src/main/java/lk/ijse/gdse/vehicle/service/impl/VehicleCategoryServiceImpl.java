package lk.ijse.gdse.vehicle.service.impl;


import lk.ijse.gdse.vehicle.dto.VehicleCategoryDTO;
import lk.ijse.gdse.vehicle.entity.VehicleCategory;
import lk.ijse.gdse.vehicle.repo.VehicleCategoryRepo;
import lk.ijse.gdse.vehicle.service.VehicleCategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    @Autowired
    VehicleCategoryRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public VehicleCategoryDTO saveCategory(VehicleCategoryDTO dto) {
        if (repo.existsById(dto.getCategoryId())) {
            throw new RuntimeException("Vehicle Category Has been Already Exists");
        } else {
            repo.save(mapper.map(dto, VehicleCategory.class));
        }
        return dto;
    }
    @Override
    public VehicleCategoryDTO updateCategory(VehicleCategoryDTO dto) {
        if (repo.existsById(dto.getCategoryId())) {
            repo.save(mapper.map(dto, VehicleCategory.class));
        } else {
            throw new RuntimeException("Vehicle Category Update Failed!");
        }
        return dto;
    }
    @Override
    public VehicleCategoryDTO searchCategory(String type) {
        if (type != null) {
            VehicleCategory category = repo.findVehicleCategoryByCategoryType(type);
            System.out.println(category.toString());
            VehicleCategoryDTO dto = mapper.map(category, VehicleCategoryDTO.class);
            return dto;
        } else {
            throw new RuntimeException("Cannot Found VehicleCategory!");
        }
    }

    @Override
    public List<VehicleCategoryDTO>findAllVehicleCategory(){
        List<VehicleCategory> all = repo.findAll();
        for (VehicleCategory dto: all) {
            System.out.println(dto.toString());
        }
        return mapper.map(all,new TypeToken<List<VehicleCategoryDTO>>(){
        }.getType());
    }

    @Override
    public void deleteVehicleCategory(String type){
        if(type!=null){
            repo.delete(repo.findVehicleCategoryByCategoryType(type));
        }else{
            throw  new RuntimeException("Delete Failed Vehicle Category");
        }
    }



}
