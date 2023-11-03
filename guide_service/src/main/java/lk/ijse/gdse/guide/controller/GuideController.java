package lk.ijse.gdse.guide.controller;


import lk.ijse.gdse.guide.dto.GuideDTO;
import lk.ijse.gdse.guide.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("api/v1/guide")
@RestController
public class GuideController {

    @Autowired
    GuideService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public GuideDTO postGuide(@RequestBody GuideDTO dto){
        return service.saveGuide(dto);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public GuideDTO putGuide(@RequestBody GuideDTO dto){
        return service.updateGuide(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GuideDTO> getAllGuide(){
        return service.getAllGuide();
    }

    @GetMapping(path ="search",params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public GuideDTO searchGuide(@RequestParam("id") String guideId){
        return service.searchGuide(guideId);
    }

    @DeleteMapping(params = {"id"})
    public void deleteHotel(@RequestParam("id")String guideId){
        service .deleteGuide(guideId);

    }


}
