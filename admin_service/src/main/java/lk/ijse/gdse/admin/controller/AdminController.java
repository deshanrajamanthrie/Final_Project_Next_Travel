package lk.ijse.gdse.admin.controller;


import lk.ijse.gdse.admin.dto.AdminDTO;
import lk.ijse.gdse.admin.repo.AdminRepo;
import lk.ijse.gdse.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AdminDTO saveAdmin(@RequestBody AdminDTO dto) {
        return service.saveAdmin(dto);
    }


}
