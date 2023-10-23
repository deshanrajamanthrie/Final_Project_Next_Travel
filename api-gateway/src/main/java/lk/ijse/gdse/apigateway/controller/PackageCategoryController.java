package lk.ijse.gdse.apigateway.controller;


import lk.ijse.gdse.apigateway.dto.GuideDTO;
import lk.ijse.gdse.apigateway.dto.HotelDTO;
import lk.ijse.gdse.apigateway.dto.PackageCategoryDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("api/v1/consume/category")
@CrossOrigin
public class PackageCategoryController {

    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllPackageCategory() {
        PackageCategoryDTO[] forObject = rest.getForObject("http://localhost:8082/api/v1/mainPackage", PackageCategoryDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200, "GetAll Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postCategory(@RequestBody PackageCategoryDTO dto) {
        rest.postForEntity("http://localhost:8082/api/v1/mainPackage", dto, PackageCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Guide Save Successfully!", null));
    }


    @GetMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> searchPackage(@RequestParam String id) {
        PackageCategoryDTO forObject = rest.getForObject("http://localhost:8082/api/v1/mainPackage?id=" + id, PackageCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get This Guide Successfully", forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePackage(@RequestBody PackageCategoryDTO dto) {
        rest.put("http://localhost:8082/api/v1/mainPackage", dto, PackageCategoryDTO.class);
    }

    @DeleteMapping(params = {"id"})
    public void deletePackage(@RequestParam("id") String pId) {
        rest.delete("http://localhost:8082/api/v1/mainPackage?id="+ pId,PackageCategoryDTO.class);
    }


}
