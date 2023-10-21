package lk.ijse.gdse.guide.service;

import lk.ijse.gdse.guide.dto.GuideDTO;
import lk.ijse.gdse.guide.entity.Guide;
import org.modelmapper.TypeToken;

import java.util.List;

public interface GuideService {
     GuideDTO saveGuide(GuideDTO dto);

     GuideDTO updateGuide(GuideDTO dto);

     List<GuideDTO> getAllGuide();

     GuideDTO searchGuide(String id);

     void deleteGuide(String id);
}
