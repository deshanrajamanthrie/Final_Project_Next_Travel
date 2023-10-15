package lk.ijse.gdse.vehicle.controller;

import lk.ijse.gdse.vehicle.dto.VehicleBrandDTO;
import lk.ijse.gdse.vehicle.service.VehicleBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/brand")
@CrossOrigin
public class VehicleBrandController {

    @Autowired
    VehicleBrandService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleBrandDTO vehicleBrand(@RequestBody VehicleBrandDTO dto){
        return service.saveVehicleBrand(dto);

    }







}
