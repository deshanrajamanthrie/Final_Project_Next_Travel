package lk.ijse.gdse.hotelService.repo;

import lk.ijse.gdse.hotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}
