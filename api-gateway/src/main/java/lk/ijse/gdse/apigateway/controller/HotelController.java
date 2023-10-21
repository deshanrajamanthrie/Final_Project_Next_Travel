package lk.ijse.gdse.apigateway.controller;

import lk.ijse.gdse.apigateway.dto.hotelDTO.HotelDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping("api/v1/consume")
public class HotelController {


    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllHotel(){
        HotelDTO [] forObject= rest.getForObject("http://localhost:8083/api/v1/hotel", HotelDTO[].class);
        return new ResponseUtil(200,"Get All Hotel SuccessFully", Arrays.asList(forObject));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil postHotel(@RequestBody HotelDTO dto){
        ResponseEntity<HotelDTO> hotelDTOResponseEntity = rest.postForEntity("http://localhost:8083/api/v1/hotel", dto, HotelDTO.class);
        return new ResponseUtil(200,"Added Successfully",hotelDTOResponseEntity.getBody());
    }
    @GetMapping(params = {"id"},produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getHotel(@RequestParam("id") String hId){
        HotelDTO forObject = rest.getForObject("http://localhost:8083/api/v1/hotel/search?id="+hId,HotelDTO.class);
        return new ResponseUtil(200,"Get Hotel Successful",forObject);
    }
    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateHotel(@RequestBody HotelDTO dto){
      /*  HotelDTO hotelDTO = rest.patchForObject(, dto, HotelDTO.class);
        return new ResponseUtil(200,"update Successfully",null);*/
      rest.put("http://localhost:8083/api/v1/hotel",dto,HotelDTO.class);

    }
    @DeleteMapping(params = {"id"})
    public void deleteHotel(@RequestParam("id") String hId){
        rest.delete("http://localhost:8083/api/v1/hotel?id="+hId,HotelDTO.class);
    }


}
