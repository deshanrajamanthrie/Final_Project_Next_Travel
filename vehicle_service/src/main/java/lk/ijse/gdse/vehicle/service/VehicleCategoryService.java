package lk.ijse.gdse.vehicle.service;

import lk.ijse.gdse.vehicle.dto.VehicleCategoryDTO;
import lk.ijse.gdse.vehicle.entity.VehicleCategory;
import org.modelmapper.TypeToken;

import java.util.List;

public interface VehicleCategoryService {

     VehicleCategoryDTO saveCategory(VehicleCategoryDTO dto);

      VehicleCategoryDTO updateCategory(VehicleCategoryDTO dto) ;

      VehicleCategoryDTO searchCategory(String type) ;

      List<VehicleCategoryDTO> findAllVehicleCategory();

      void deleteVehicleCategory(String type);

}
