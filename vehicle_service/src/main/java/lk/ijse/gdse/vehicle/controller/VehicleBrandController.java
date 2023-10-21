package lk.ijse.gdse.vehicle.controller;

import lk.ijse.gdse.vehicle.dto.VehicleBrandDTO;
import lk.ijse.gdse.vehicle.service.VehicleBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/brand")
@CrossOrigin
public class VehicleBrandController {

    @Autowired
    VehicleBrandService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleBrandDTO postVehicleBrand(@RequestBody VehicleBrandDTO dto){
        return service.saveVehicleBrand(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleBrandDTO putVehicleBrand(@RequestBody VehicleBrandDTO dto){
       return service.updateVehicleBrand(dto);
    }

    @PutMapping(path = "/image",params = "id",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(@RequestPart MultipartFile file,@RequestParam  Long id) throws IOException {
        VehicleBrandDTO vehicleBrandDTO = service.searchVehicleBrand(id);
        vehicleBrandDTO.setImages(file.getBytes());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleBrandDTO>getAllVehicle(){
        return service.getAllVehicle();
    }

    @GetMapping(path = "/search",params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleBrandDTO searchVehicle(@RequestParam("id")Long vId){
        return service.searchVehicleBrand(vId);
    }


    @DeleteMapping(params = {"/id"})
    public void deleteVehicle(@RequestParam("id")Long vId){
        service.deleteVehicleBrand(vId);
    }









}
