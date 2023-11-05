package lk.ijse.gdse.travelService.service.impl;

import lk.ijse.gdse.travelService.dto.TravelDTO;
import lk.ijse.gdse.travelService.entity.Travel;
import lk.ijse.gdse.travelService.repo.TravelRepo;
import lk.ijse.gdse.travelService.service.TravelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@Transactional
public class TravelServiceImpl implements TravelService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    TravelRepo repo;


    public TravelDTO saveTravel(TravelDTO dto){
        if(repo.existsById(dto.getId())){
            throw new RuntimeException("Travel Already Added!");
        }else{
            repo.save(mapper.map(dto, Travel.class));
        }
        return dto;
    }

    public TravelDTO UpdateTravel(TravelDTO dto){
        if(!repo.existsById(dto.getId())){
            throw new RuntimeException("Travel Update Failed!");
        }else{
            repo.save(mapper.map(dto, Travel.class));
        }
        return dto;
    }

    public List<TravelDTO>getAllTravel(){
        List<Travel> all = repo.findAll();
        all.stream().forEach(v->{
            System.out.println(v.toString());
        });
        for (Travel travel: all) {
          travel.getPackageCategory().setTravels(null);

        }
        return mapper.map(all,new TypeToken<List<TravelDTO>>(){
        }.getType());
    }

    public TravelDTO searchTravel(Long id){
        if(!repo.existsById(id)){
            throw  new RuntimeException("Travel Has been Not found!");
        }else{
            Travel travel = repo.findById(id).get();
            travel.getPackageCategory().setTravels(null);
            return mapper.map(travel, TravelDTO.class);
        }
    }


    public void deleteTravel(Long id){
        if(!repo.existsById(id)){
            throw  new RuntimeException("Travel Has been Not found!");
        }else{
            repo.delete(repo.findById(id).get());

        }
    }
}
