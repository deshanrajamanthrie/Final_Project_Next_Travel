package lk.ijse.gdse.user.service;

import lk.ijse.gdse.user.dto.BookingDTO;
import lk.ijse.gdse.user.entity.Booking;
import org.modelmapper.TypeToken;

import java.util.List;

public interface BookingService {
     BookingDTO saveBooking(BookingDTO dto);

      BookingDTO updateBooking(BookingDTO dto);

     List<BookingDTO> getAllBooking();

     BookingDTO searchBook(Long  id);

     void deleteBooking(Long id);
}
