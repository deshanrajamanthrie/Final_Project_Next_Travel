package lk.ijse.gdse.apigateway.controller;

import lk.ijse.gdse.apigateway.dto.BookingDTO;
import lk.ijse.gdse.apigateway.dto.UserDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@CrossOrigin
@RequestMapping("api/v1/booking/consume")
public class BookingController {

    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllBooking(){
        BookingDTO[] forObject = rest.getForObject("http://localhost:8084/api/v1/booking", BookingDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get All Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postBooking(@RequestBody BookingDTO dto){
        rest.postForEntity("http://localhost:8084/api/v1/booking",dto,BookingDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Save Booking Successfully",null));
    }

    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getBooking(@RequestParam("id") Long bId){
        BookingDTO forObject = rest.getForObject("http://localhost:8084/api/v1/booking/search?id=" + bId, BookingDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get  a Booking",forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putUser(@RequestBody BookingDTO dto){
        rest.put("http://localhost:8084/api/v1/booking",dto,BookingDTO.class);
    }

    @DeleteMapping(params = {"id"})
    public void deleteUser(@RequestParam Long id){
        rest.delete("http://localhost:8084/api/v1/booking?id="+id,BookingDTO.class);
    }

}
