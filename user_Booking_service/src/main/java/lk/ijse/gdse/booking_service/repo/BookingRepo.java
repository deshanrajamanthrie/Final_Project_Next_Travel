package lk.ijse.gdse.booking_service.repo;

import lk.ijse.gdse.booking_service.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Long> {
}
