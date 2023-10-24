package lk.ijse.gdse.vehicle.controller;

import lk.ijse.gdse.vehicle.dto.VehicleCategoryDTO;
import lk.ijse.gdse.vehicle.service.VehicleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/cate")
public class VehicleCategoryController {
    @Autowired
    VehicleCategoryService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleCategoryDTO postCategory(@RequestBody VehicleCategoryDTO dto){
        return service.saveCategory(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleCategoryDTO putCategory(@RequestBody VehicleCategoryDTO dto){
       return service.updateCategory(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleCategoryDTO> allGetCategory(){
       return service.findAllVehicleCategory();
    }

    @GetMapping(path = "search",params = {"type"},produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleCategoryDTO searchCategory(@RequestParam("type") String ctype){
        return service.searchCategory(ctype);
    }

    @DeleteMapping(params = {"type"},produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCategory(@RequestParam String type){
        service.deleteVehicleCategory(type);
    }




}
