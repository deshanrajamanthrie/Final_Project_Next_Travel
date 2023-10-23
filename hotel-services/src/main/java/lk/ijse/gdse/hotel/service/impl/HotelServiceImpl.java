package lk.ijse.gdse.hotel.service.impl;

import lk.ijse.gdse.hotel.dto.HotelDTO;
import lk.ijse.gdse.hotel.entity.Hotel;
import lk.ijse.gdse.hotel.repo.HotelRepo;
import lk.ijse.gdse.hotel.service.HotelService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo repo;

    @Autowired
    ModelMapper mapper;


    public HotelDTO saveHotel(HotelDTO dto) {
        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("Hotel Already Added!");
        } else {
            repo.save(mapper.map(dto, Hotel.class));
        }
        return dto;
    }

    public HotelDTO updateHotel(HotelDTO dto) {
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Hotel Not Found!");
        } else {
            repo.save(mapper.map(dto, Hotel.class));
        }
        return dto;
    }

    public List<HotelDTO> getAllHotel() {
        repo.findAll().stream().forEach(v -> {
            System.out.println(v.toString());
        });
       return mapper.map(repo.findAll(),new TypeToken<List<HotelDTO>>(){}.getType());
    }

    public HotelDTO searchHotel(String id){
        if(!repo.existsById(id)){
            throw  new RuntimeException("Hotel Has been Not Found!");
        }else {
            return mapper.map(repo.findById(id).get(),HotelDTO.class);
        }
    }

    public void deleteHotel(String id){
        if(!repo.existsById(id)){
            throw  new RuntimeException("Hotel Has been Not Found!");
        }else {

           repo.delete(repo.findById(id).get());
        }
    }
}
