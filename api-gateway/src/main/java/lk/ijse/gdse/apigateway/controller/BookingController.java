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
@RequestMapping("api/v1/consume/booking")
public class BookingController {

    private final String url="http://deshanz-vivobook:8084/api/v1/booking";


    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllBooking(){
        BookingDTO[] forObject = rest.getForObject(url, BookingDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get All Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postBooking(@RequestBody BookingDTO dto){
        rest.postForEntity(url,dto,BookingDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Save Booking Successfully",null));
    }

    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getBooking(@RequestParam("id") Long bId){
        BookingDTO forObject = rest.getForObject(url+"/search?id="+bId, BookingDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get  a Booking",forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> putUser(@RequestBody BookingDTO dto){
        rest.put(url,dto,BookingDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Update Successfully!",dto));
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<ResponseUtil> deleteUser(@RequestParam Long id){
        rest.delete(url+"?id="+id,BookingDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Delete Successfully",null));
    }

}
