package lk.ijse.gdse.booking_service.service;

import lk.ijse.gdse.booking_service.dto.BookingDTO;
import lk.ijse.gdse.booking_service.entity.Booking;
import org.modelmapper.TypeToken;

import java.util.List;

public interface BookingService {
    public BookingDTO saveBooking(BookingDTO dto);

    public  BookingDTO updateBooking(BookingDTO dto);

    public List<BookingDTO> getAllBooking();

    public BookingDTO searchBook(Long  id);

    public void deleteBooking(Long id);
}
