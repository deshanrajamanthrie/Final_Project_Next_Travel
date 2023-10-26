package lk.ijse.gdse.apigateway.controller;

import lk.ijse.gdse.apigateway.dto.VehicleCategoryDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("api/v1/vehicleCategory/consume")
@CrossOrigin
public class VehicleCategoryController {

    private final String url = "http://deshanz-vivobook:8081/api/v1/cate";

    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllVehicleCategory() {
        VehicleCategoryDTO[] forObject = rest.getForObject(url, VehicleCategoryDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get All Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postAllVehicle(@RequestBody VehicleCategoryDTO dto) {
        rest.postForEntity(url, dto, VehicleCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Save Successed!", null));
    }


    @GetMapping(path = "/search", params = {"type"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllVehicle(@RequestParam("type") String type) {
        VehicleCategoryDTO forObject = rest.getForObject(url + "/search?type=" + type, VehicleCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get A Vehicle Category Successfully", forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> updateVehicleCategory(@RequestBody VehicleCategoryDTO dto) {
        rest.put(url, dto, VehicleCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Update Successfully!", null));
    }


    @DeleteMapping(params = {"type"})
    public ResponseEntity<ResponseUtil> deleteVehicleCategory(@RequestParam("type") String type) {
        rest.delete(url + "?type=" + type, VehicleCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Delete Successfully!", null));
    }


}
