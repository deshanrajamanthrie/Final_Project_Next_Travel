package lk.ijse.gdse.user.controller;

import lk.ijse.gdse.user.dto.UserDTO;
import lk.ijse.gdse.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO postUser(@RequestBody UserDTO dto) {
        return service.saveUser(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO updateUser(@RequestBody UserDTO dto) {
        return service.updateUser(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUser() {
        return service.getAllUser();
    }


    @DeleteMapping(params = {"id"})
    public void deleteUSer(@RequestParam("id") Long uId){
        service.deleteUser(uId);
    }

    @GetMapping(path = "/search",params = {"id"})
    public UserDTO searchUser(@RequestParam("id")Long uId){
        return service.searchUser(uId);
    }


    @GetMapping(path = "/searchName",params = {"name"})
    public UserDTO searchUserName(@RequestParam("name")String mName){
        return service.searchUserName(mName);
    }
}
