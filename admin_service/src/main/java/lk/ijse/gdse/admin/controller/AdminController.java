package lk.ijse.gdse.admin.controller;


import lk.ijse.gdse.admin.dto.AdminDTO;
import lk.ijse.gdse.admin.repo.AdminRepo;
import lk.ijse.gdse.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {


    @Autowired
    AdminService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDTO saveAdmin(@RequestBody AdminDTO dto) {
        return service.saveAdmin(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDTO updateAdmin(@RequestBody AdminDTO dto) {
        return service.updateAdmin(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdminDTO> getAllAdmin() {
        return service.getAllAdmin();
    }

    @GetMapping(path = "search", params = "email", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDTO searchAdmin(@RequestParam("email") String email) {
        System.out.println(email);
        return service.getAdmin(email);
    }

    @DeleteMapping(params = {"id"})
    public void deleteAdmin(@RequestParam("id") Long myId) {
        service.deleteAdmin(myId);
    }


}
