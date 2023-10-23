package lk.ijse.gdse.hotel.repo;

import lk.ijse.gdse.hotel.entity.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}
