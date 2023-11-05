package lk.ijse.gdse.apigateway.controller;


import lk.ijse.gdse.apigateway.dto.TravelDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RequestMapping("api/v1/consume/travel")
@CrossOrigin
@RestController
public class TravelController {

    private  final String  url="http://deshanz-vivobook:8082/api/v1/travel";

    @Autowired
    RestTemplate restTemplate;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <ResponseUtil>getAllTravel(){
        TravelDTO[] forObject = restTemplate.getForObject(url, TravelDTO[].class);
        return  ResponseEntity.ok(new ResponseUtil(200,"Get All Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil>postAllTravel(@RequestBody TravelDTO dto){
        ResponseEntity<TravelDTO> travel = restTemplate.postForEntity(url, dto, TravelDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Post Successfully",travel));
    }

    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil>getTravel(@RequestParam Long id){
        TravelDTO forObject = restTemplate.getForObject(url+"/search?id=" + id, TravelDTO.class);
        return  ResponseEntity.ok(new ResponseUtil(200,"Get Travel Successfully!",forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> putTravel(@RequestBody TravelDTO dto){
        restTemplate.put(url,dto,TravelDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Update Successfully!",null));
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<ResponseUtil>  deleteTravel(@RequestParam Long id){
        restTemplate.delete("http://localhost:8082/api/v1/travel?id="+id,TravelDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Delete Successfully!",null));
    }


}
