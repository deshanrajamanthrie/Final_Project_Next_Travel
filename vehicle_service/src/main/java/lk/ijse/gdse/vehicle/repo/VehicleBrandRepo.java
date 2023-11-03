package lk.ijse.gdse.vehicle.repo;

import lk.ijse.gdse.vehicle.dto.VehicleBrandDTO;
import lk.ijse.gdse.vehicle.entity.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleBrandRepo extends JpaRepository<VehicleBrand,Long> {

}
