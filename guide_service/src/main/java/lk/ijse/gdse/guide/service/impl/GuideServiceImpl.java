package lk.ijse.gdse.guide.service.impl;

import lk.ijse.gdse.guide.dto.GuideDTO;
import lk.ijse.gdse.guide.entity.Guide;
import lk.ijse.gdse.guide.repo.GuideRepo;
import lk.ijse.gdse.guide.service.GuideService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    GuideRepo repo;


    public GuideDTO saveGuide(GuideDTO dto) {
        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("Guide is Already Added!");
        } else {
            repo.save(mapper.map(dto, Guide.class));
        }
        return dto;
    }

    public GuideDTO updateGuide(GuideDTO dto) {
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Guide Not Found!");
        } else {
            repo.save(mapper.map(dto, Guide.class));
        }
        return dto;
    }

    public List<GuideDTO> getAllGuide() {
        repo.findAll().stream().forEach(v -> {
            System.out.println(v.toString());
        });
        return mapper.map(repo.findAll(),new TypeToken<List<GuideDTO>>(){}.getType());
    }

    public GuideDTO searchGuide(String id){
        if(!repo.existsById(id)){
            throw  new RuntimeException("Guide Has been Not Found!");
        }else {
            return mapper.map(repo.findById(id).get(),GuideDTO.class);
        }
    }

    public void deleteGuide(String id){
        if(!repo.existsById(id)){
            throw  new RuntimeException("Guide Has been Not Found!");
        }else {
            repo.delete(repo.findById(id).get());
        }
    }

}
