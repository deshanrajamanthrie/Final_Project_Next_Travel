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

    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllGuide() {
        GuideDTO[] forObject = rest.getForObject("http://localhost:8086/api/v1/guide", GuideDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200, "GetAll Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postGuide(@RequestBody GuideDTO dto) {
        ResponseEntity<GuideDTO> guideDTOResponseEntity = rest.postForEntity("http://localhost:8086/api/v1/guide", dto, GuideDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Guide Save Successfully!", null));
    }

    @GetMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> searchGuide(@RequestParam String id) {
        GuideDTO forObject = rest.getForObject("http://localhost:8086/api/v1/guide/search?id="+ id, GuideDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get This Guide Successfully", forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGuide(@RequestBody GuideDTO dto) {
        rest.put("http://localhost:8086/api/v1/guide",dto ,GuideDTO.class);
    }

    @DeleteMapping(params = "id")
    public  void deleteGuide(@RequestParam String id){
        rest.delete("http://localhost:8086/api/v1/guide",id,GuideDTO.class);
    }

}
