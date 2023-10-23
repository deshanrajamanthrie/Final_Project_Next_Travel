package lk.ijse.gdse.user.repo;

import lk.ijse.gdse.user.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Long> {
}
