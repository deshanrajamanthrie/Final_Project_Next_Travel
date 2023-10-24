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

    @Autowired
    RestTemplate rest;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getAllUser(){
        UserDTO[] forObject = rest.getForObject("http://localhost:8084/api/v1/user", UserDTO[].class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get All Successfully", Arrays.asList(forObject)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> postAllUser(@RequestBody UserDTO dto){
        rest.postForEntity("http://localhost:8084/api/v1/user",dto,UserDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Save User Successfully",null));
    }

    @GetMapping(path = "/searchId",params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> getUser(@RequestParam("id") Long uId){
        UserDTO forObject = rest.getForObject("http://localhost:8084/api/v1/user/search?id="+uId, UserDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get  a User",forObject));

    }

    @GetMapping(path = "searchType",produces = MediaType.APPLICATION_JSON_VALUE,params = {"type"})
    public ResponseEntity<ResponseUtil> getUserName(@RequestParam("type")  String name){
        UserDTO forObject = rest.getForObject("http://localhost:8084/api/v1/user/searchName?name=" + name, UserDTO.class);
        return ResponseEntity.ok(new ResponseUtil(200,"Get a User",forObject));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putUser(@RequestBody UserDTO dto){
        rest.put("http://localhost:8084/api/v1/user",dto,UserDTO.class);
    }

    @DeleteMapping(params = {"id"})
    public void deleteUser(@RequestParam Long id){
        rest.delete("http://localhost:8084/api/v1/user?id="+id,UserDTO.class);

    }





}
