package lk.ijse.gdse.vehicle.repo;

import lk.ijse.gdse.vehicle.entity.VehicleImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleImageRepo extends JpaRepository<VehicleImage,Long> {

     /*Optional<VehicleImage>findByName();*/



}
