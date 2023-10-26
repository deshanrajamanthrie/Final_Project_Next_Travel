package lk.ijse.gdse.apigateway.controller;

import lk.ijse.gdse.apigateway.dto.UserDTO;
import lk.ijse.gdse.apigateway.util.ResponseUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("api/v1/consume/users")
@CrossOrigin
public class UsersController {

    private final String url = "http://deshanz-vivobook:8084/api/v1/user";

    @Autowired
    RestTemplate rest;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllUser() {
        UserDTO[] forObject = rest.getForObject(url, UserDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get All Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postAllUser(@RequestBody UserDTO dto) {
        rest.postForEntity(url, dto, UserDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Save User Successfully", null));
    }

    @GetMapping(path = "/searchId", params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getUser(@RequestParam("id") Long uId) {
        UserDTO forObject = rest.getForObject(url + "/search?id=" + uId, UserDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get  a User", forObject));

    }

    @GetMapping(path = "searchType", produces = MediaType.APPLICATION_JSON_VALUE, params = {"type"})
    public ResponseEntity<ResponseUtil> getUserName(@RequestParam("type") String name) {
        UserDTO forObject = rest.getForObject(url+"/searchName?name=" + name, UserDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Get a User", forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> putUser(@RequestBody UserDTO dto) {
        rest.put(url, dto, UserDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Update Successfully!", null));
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<ResponseUtil> deleteUser(@RequestParam Long id) {
        rest.delete(url+"?id=" + id, UserDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200, "Delete Successfully!", null));
    }


}
