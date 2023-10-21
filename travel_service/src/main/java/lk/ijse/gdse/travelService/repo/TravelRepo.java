package lk.ijse.gdse.travelService.repo;

import lk.ijse.gdse.travelService.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepo extends JpaRepository<Travel,String> {
}
