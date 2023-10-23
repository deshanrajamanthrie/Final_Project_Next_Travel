package lk.ijse.gdse.hotelService.service;

import lk.ijse.gdse.hotelService.dto.HotelDTO;
import lk.ijse.gdse.hotelService.entity.Hotel;
import org.modelmapper.TypeToken;

import java.util.List;

public interface HotelService {
     HotelDTO saveHotel(HotelDTO dto);

     HotelDTO updateHotel(HotelDTO dto);

     List<HotelDTO> getAllHotel();

     HotelDTO searchHotel(String id);
     void deleteHotel(String id);

}
