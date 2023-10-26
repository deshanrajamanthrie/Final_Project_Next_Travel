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


    private final String url="http://deshanz-vivobook:8081/api/v1/brand";

    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil>getAllVehicleBrand(){
        VehicleBrandDTO[] forObject = rest.getForObject(url, VehicleBrandDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get All Successfully!",Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ResponseUtil> postVehicleBrand(@RequestBody VehicleBrandDTO dto){
        ResponseEntity<VehicleBrandDTO> vehicleBrandDTOResponseEntity = rest.postForEntity(url, dto, VehicleBrandDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Save Successed!",vehicleBrandDTOResponseEntity));
    }

    @GetMapping(path = "/search",params = {"id"})
    public ResponseEntity<ResponseUtil> searchVehicleBrand(@RequestParam("id")Long vId){
        VehicleBrandDTO forObject = rest.getForObject(url+"/search?id=" + vId, VehicleBrandDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get a Vehicle",forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> putVehicle(@RequestBody VehicleBrandDTO dto){
        rest.put(url,dto,VehicleBrandDTO.class);
        return  ResponseEntity.ok(new ResponseUtil(200,"Update Successfully!",null));
    }


    @DeleteMapping(params = {"id"})
    public ResponseEntity<ResponseUtil> deleteVehicle(@RequestParam("id") Long vId){
        rest.delete(url+"?id="+vId,VehicleBrandDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Delete Successfully!",null));
    }





}
