package lk.ijse.gdse.hotel.service;

import lk.ijse.gdse.hotel.dto.HotelDTO;


import java.util.List;

public interface HotelService {
     HotelDTO saveHotel(HotelDTO dto);

     HotelDTO updateHotel(HotelDTO dto);

     List<HotelDTO> getAllHotel();

     HotelDTO searchHotel(String id);
     void deleteHotel(String id);

}
