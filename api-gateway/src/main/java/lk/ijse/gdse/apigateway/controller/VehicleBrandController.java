package lk.ijse.gdse.apigateway.controller;

import lk.ijse.gdse.apigateway.dto.VehicleBrandDTO;
import lk.ijse.gdse.apigateway.dto.VehicleCategoryDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping("api/v1/consume/brand")
public class VehicleBrandController {

    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil>getAllVehicleBrand(){
        VehicleBrandDTO[] forObject = rest.getForObject("http://localhost:8081/api/v1/brand", VehicleBrandDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get All Successfully!",Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ResponseUtil> postVehicleBrand(@RequestBody VehicleBrandDTO dto){
        ResponseEntity<VehicleBrandDTO> vehicleBrandDTOResponseEntity = rest.postForEntity("http://localhost:8081/api/v1/brand", dto, VehicleBrandDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Save Successed!",vehicleBrandDTOResponseEntity));
    }

    @GetMapping(path = "/search",params = {"id"})
    public ResponseEntity<ResponseUtil> searchVehicleBrand(@RequestParam("id")Long vId){
        VehicleBrandDTO forObject = rest.getForObject("http://localhost:8081/api/v1/brand/search?id=" + vId, VehicleBrandDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get a Vehicle",forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putVehicle(@RequestBody VehicleBrandDTO dto){
        rest.put("http://localhost:8081/api/v1/brand",dto,VehicleBrandDTO.class);
    }


    @DeleteMapping(params = {"id"})
    public void deleteVehicle(@RequestParam("id") Long vId){
        rest.delete("http://localhost:8081/api/v1/brand?id="+vId,VehicleBrandDTO.class);
    }





}
