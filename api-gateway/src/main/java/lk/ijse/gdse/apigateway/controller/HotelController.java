package lk.ijse.gdse.apigateway.controller;

import lk.ijse.gdse.apigateway.dto.HotelDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping("api/v1/hotel/consume")
public class HotelController {


    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllHotel(){
        HotelDTO [] forObject= rest.getForObject("http://localhost:8083/api/v1/hotel", HotelDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get All Hotel SuccessFully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postHotel(@RequestBody HotelDTO dto){
        ResponseEntity<HotelDTO> hotelDTOResponseEntity = rest.postForEntity("http://localhost:8083/api/v1/hotel", dto, HotelDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Added Successfully",null));
    }
    @GetMapping(params = {"id"},produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getHotel(@RequestParam("id") String hId){
        HotelDTO forObject = rest.getForObject("http://localhost:8083/api/v1/hotel/search?id="+hId,HotelDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get Hotel Successful",forObject));
    }
    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> updateHotel(@RequestBody HotelDTO dto){
      rest.put("http://localhost:8083/api/v1/hotel",dto,HotelDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Update Successfully!",null));
    }
    @DeleteMapping(params = {"id"})
    public ResponseEntity<ResponseUtil> deleteHotel(@RequestParam("id") String hId){
        rest.delete("http://localhost:8083/api/v1/hotel?id="+hId,HotelDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Update Successfully!",null));
    }


}
