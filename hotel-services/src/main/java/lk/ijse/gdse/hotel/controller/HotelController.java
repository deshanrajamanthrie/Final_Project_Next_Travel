package lk.ijse.gdse.hotel.controller;

import lk.ijse.gdse.hotel.dto.HotelDTO;
import lk.ijse.gdse.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hotel")
@CrossOrigin
public class HotelController {

    @Autowired
    HotelService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HotelDTO postHotel(@RequestBody HotelDTO dto){
        System.out.println(dto.toString());
        return service.saveHotel(dto);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HotelDTO putHotel(@RequestBody HotelDTO dto){
        return service.updateHotel(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelDTO> getAllHotel(){
        return service.getAllHotel();
    }

    @GetMapping(path ="search",params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelDTO searchHotel(@RequestParam("id") String hotelId){
        return service.searchHotel(hotelId);
    }



    @DeleteMapping(params = "id")
    public void deleteHotel(@RequestParam("id")String hotelId){
        service .deleteHotel(hotelId);

    }





}
