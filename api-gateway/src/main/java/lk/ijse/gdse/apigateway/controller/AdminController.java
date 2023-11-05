package lk.ijse.gdse.apigateway.controller;


import lk.ijse.gdse.apigateway.dto.AdminDTO;
import lk.ijse.gdse.apigateway.dto.UserDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RequestMapping("api/v1/consume/admin")
@RestController
@CrossOrigin
public class AdminController {

    private final String url = "http://deshanz-vivobook:8087/api/v1/admin";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllAdmin() {
        AdminDTO[] forObject = restTemplate.getForObject(url, AdminDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get All Admins", Arrays.asList(forObject)));
    }

    @PostMapping(path = "register",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> saveAdmin(@RequestBody AdminDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        restTemplate.postForEntity(url, dto, UserDTO.class);

        return ResponseEntity.ok(new ResponseUtil(200, "Save Successfully Admin", null));
    }

    @PutMapping(path = "update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> updateAdmin(@RequestBody AdminDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        restTemplate.put(url, dto, AdminDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Save Successfully Admin", null));
    }

    @GetMapping(path = "search", params = {"email"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAdmin(@RequestParam("email") String adminEmail) {
        AdminDTO forObject = restTemplate.getForObject(url + "/search?email=" + adminEmail, AdminDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get Admin", forObject));
    }

    @DeleteMapping(path = "delete",params = {"id"})
    public ResponseEntity<ResponseUtil> deleteAdmin(@RequestParam("id") Long adminId){
        restTemplate.delete(url+"?id="+adminId);
        return ResponseEntity.ok(new ResponseUtil(200,"Delete Successfully!",null));
    }


}
