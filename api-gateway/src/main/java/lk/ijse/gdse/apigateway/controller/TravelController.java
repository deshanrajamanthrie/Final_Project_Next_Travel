package lk.ijse.gdse.apigateway.controller;


import lk.ijse.gdse.apigateway.dto.TravelDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RequestMapping("api/v1/travel/consume")
@CrossOrigin
@RestController
public class TravelController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <ResponseUtil>getAllTravel(){
        TravelDTO[] forObject = restTemplate.getForObject("http://localhost:8082/api/v1/travel", TravelDTO[].class);
        return  ResponseEntity.ok(new ResponseUtil(200,"Get All Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil>postAllTravel(@RequestBody TravelDTO dto){
        restTemplate.postForEntity("http://localhost:8082/api/v1/travel",dto,TravelDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Post Successfully",null));
    }

    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil>getTravel(@RequestParam String id){
        TravelDTO forObject = restTemplate.getForObject("http://localhost:8082/api/v1/travel/search?id=" + id, TravelDTO.class);
        return  ResponseEntity.ok(new ResponseUtil(200,"Get Travel Successfully!",forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putTravel(@RequestBody TravelDTO dto){
        restTemplate.put("http://localhost:8082/api/v1/travel",dto,TravelDTO.class);
    }

    @DeleteMapping(params = {"id"})
    public void  deleteTravel(@RequestParam String id){
        restTemplate.delete("http://localhost:8082/api/v1/travel?id="+id,TravelDTO.class);
    }


}
