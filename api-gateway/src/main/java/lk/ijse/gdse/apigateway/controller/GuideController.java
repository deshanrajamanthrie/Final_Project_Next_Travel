package lk.ijse.gdse.apigateway.controller;

import lk.ijse.gdse.apigateway.dto.GuideDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
@RequestMapping("api/v1/mainGuide")
@CrossOrigin
public class GuideController {

    private final  String url="http://deshanz-vivobook:8086/api/v1/guide";

    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllGuide() {
        GuideDTO[] forObject = rest.getForObject(url, GuideDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200, "GetAll Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postGuide(@RequestBody GuideDTO dto) {
        ResponseEntity<GuideDTO> guideDTOResponseEntity = rest.postForEntity(url, dto, GuideDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Guide Save Successfully!", null));
    }

    @GetMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> searchGuide(@RequestParam String id) {
        GuideDTO forObject = rest.getForObject(url+"/search?id="+ id, GuideDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get This Guide Successfully", forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> updateGuide(@RequestBody GuideDTO dto) {
        rest.put(url,dto ,GuideDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Update Successfully!",null));
    }

    @DeleteMapping(params = "id")
    public  ResponseEntity<ResponseUtil> deleteGuide(@RequestParam String id){
        rest.delete(url+"?id=",id,GuideDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Delete Successfully !",null));
    }

}
