package lk.ijse.gdse.vehicle.service;

import lk.ijse.gdse.vehicle.dto.VehicleBrandDTO;
import lk.ijse.gdse.vehicle.entity.VehicleBrand;
import org.modelmapper.TypeToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleBrandService {
    VehicleBrandDTO saveVehicleBrand(VehicleBrandDTO dto);

    VehicleBrandDTO updateVehicleBrand(VehicleBrandDTO dto);

    List<VehicleBrandDTO> getAllVehicle();

    VehicleBrandDTO searchVehicleBrand(Long id);

    void deleteVehicleBrand(Long id);
}
