package lk.ijse.gdse.vehicle.repo;

import lk.ijse.gdse.vehicle.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryRepo extends JpaRepository<VehicleCategory,Long> {

    VehicleCategory findVehicleCategoryByCategoryType(String type);



}
