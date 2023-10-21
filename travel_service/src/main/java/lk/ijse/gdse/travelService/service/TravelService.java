package lk.ijse.gdse.travelService.service;

import lk.ijse.gdse.travelService.dto.TravelDTO;
import lk.ijse.gdse.travelService.entity.Travel;
import org.modelmapper.TypeToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelService  {
      TravelDTO saveTravel(TravelDTO dto);
      TravelDTO UpdateTravel(TravelDTO dto);

      List<TravelDTO>getAllTravel();

      TravelDTO searchTravel(String id);


      void deleteTravel(String id);
}
