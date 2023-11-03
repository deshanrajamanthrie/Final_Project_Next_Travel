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

    private final String url="http://deshanz-vivobook:8082/api/v1/mainPackage";

    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllPackageCategory() {
        PackageCategoryDTO[] forObject = rest.getForObject(url, PackageCategoryDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200, "GetAll Successfully", Arrays.asList(forObject)));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postCategory(@RequestBody PackageCategoryDTO dto) {
        rest.postForEntity(url, dto, PackageCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, " Save Successfully!", null));
    }


    @GetMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> searchPackage(@RequestParam String id) {
        PackageCategoryDTO forObject = rest.getForObject(url+"?id=" + id, PackageCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get  Successfully", forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> updatePackage(@RequestBody PackageCategoryDTO dto) {
        rest.put(url, dto, PackageCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Update Successfully!",null));
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<ResponseUtil> deletePackage(@RequestParam("id") String pId) {
        rest.delete(url+"?id="+ pId,PackageCategoryDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Delete Successfully",null));
    }


}
