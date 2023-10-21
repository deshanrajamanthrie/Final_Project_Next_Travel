package lk.ijse.gdse.travelService.controller;

import lk.ijse.gdse.travelService.dto.TravelDTO;
import lk.ijse.gdse.travelService.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/travel")
public class TravelController {

    @Autowired
    TravelService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TravelDTO postTravel(@RequestBody TravelDTO dto){
       return service.saveTravel(dto);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TravelDTO updateTravel(@RequestBody TravelDTO dto){
        return service.UpdateTravel(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TravelDTO> getAllTravel(){
       return service.getAllTravel();
    }


    @GetMapping(path = "search",params ={"id"} ,produces = MediaType.APPLICATION_JSON_VALUE)
    public TravelDTO searchTravel(@RequestParam("id") String tId){
        return service.searchTravel(tId);
    }


    @DeleteMapping(params = {"id"})
    public void deleteTravel(@RequestParam("id")String tId){
        service.deleteTravel(tId);
    }


}
