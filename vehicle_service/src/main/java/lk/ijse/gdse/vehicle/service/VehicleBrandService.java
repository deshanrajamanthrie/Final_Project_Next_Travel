package lk.ijse.gdse.vehicle.service;

import lk.ijse.gdse.vehicle.dto.VehicleBrandDTO;
import lk.ijse.gdse.vehicle.entity.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleBrandService {
    public VehicleBrandDTO saveVehicleBrand(VehicleBrandDTO dto);
}
