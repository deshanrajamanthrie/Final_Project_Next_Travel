package lk.ijse.gdse.travelService.controller;

import lk.ijse.gdse.travelService.dto.PackageCategoryDTO;
import lk.ijse.gdse.travelService.service.PackageCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/mainPackage")
public class PackageCategoryController {

    @Autowired
    PackageCategoryService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PackageCategoryDTO postPackage(@RequestBody PackageCategoryDTO dto) {
        return service.savePackageCategory(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PackageCategoryDTO> getPackageCategory() {
        return service.getAllCategory();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PackageCategoryDTO updatePackage(@RequestBody PackageCategoryDTO dto) {
        return service.updatePackageCategory(dto);
    }
    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public PackageCategoryDTO searchPackage(@RequestParam("id") String myId){
        return service.searchPackageCategory(myId);
    }
    @DeleteMapping(params = {"id"})
    public void deletePackage(@RequestParam("id") String myId){
        service.deletePackageCategory(myId);
    }


}
